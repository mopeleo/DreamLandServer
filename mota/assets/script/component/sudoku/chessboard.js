var sudoku = require("sudoku");
var GameLib = require("gameLib");
var PlayerData = require("playerData");

var BOARD_CELL_COLOR_INIT = cc.Color.BLACK.fromHEX("#4a6b86");          //单元格初始颜色
var BOARD_CELL_COLOR_SAMENUMBER = cc.Color.BLACK.fromHEX("#8198ab");    //单元格相同数字颜色
var BOARD_CELL_COLOR_BLOCK = cc.Color.BLACK.fromHEX("#5d7a93");         //单元格同宫同列同行颜色
var BOARD_CELL_COLOR_EDIT = cc.Color.BLACK.fromHEX("#F09559");          //单元格编辑颜色
var BOARD_CELL_COLOR_ERROR = cc.Color.RED;                              //单元格冲突错误颜色
var BOARD_CELL_OPACITY_INIT = 255;                                      //单元格初始透明度

var BOARD_CELL_TEXT_COLOR_READONLY = cc.Color.BLACK;            //单元格文字只读
var BOARD_CELL_TEXT_COLOR_CANEDIT = cc.Color.WHITE;             //单元格文字可编辑
var KEY_COLOR_INIT = cc.Color.BLACK.fromHEX("#1B262E");         //数字键盘初始颜色

var DIALOG_TEXT_NORMAL = cc.Color.WHITE;        //对话框正常文字
var DIALOG_TEXT_ERROR = cc.Color.RED;           //对话框错误信息

var COUNT_TYPE = 1;         //计数器显示类型，1显示数字存在的个数，0显示数字缺失的个数

var BOARD_CELL_SIZE = 65 + 2;                       //单元格大小，+1是每个格子之间的距离为1；
var BOARD_RADIUS = Math.floor(sudoku.block/2);      //棋盘半径，即边到中心（0，0）有多少个格子
var BLOCK_SIZE = Math.sqrt(sudoku.block);           //宫大小 ？*？

cc.Class({
    extends: cc.Component,

    properties: {
        chessboardNode: cc.Node,
        numberKeyNode: cc.Node,
        numberCountNode: cc.Node,
        clockNode: cc.Node,
        cellPrefab: cc.Prefab,
        // levelStarNode: cc.Node,
        sceneLab: cc.Label,
        goldLab: cc.Label,
        errorLab: cc.Label,
        dialogNode: cc.Node,
        dialogDynamicBtn: cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        //初始话对话框
        this.dialogNode.on(cc.Node.EventType.TOUCH_START,function(event){
            event.stopPropagation();
        });
        this.dialogNode.on(cc.Node.EventType.TOUCH_END, function (event) {
            event.stopPropagation();
        });

        this.rowArray = new Array(sudoku.block);
        this.colArray = new Array(sudoku.block);
        this.blockArray = new Array(sudoku.block);
        this.numberArray = new Array(sudoku.block + 1);

        //缓存单元格，不刷新场景时使用
        this.cellCache = new Array(sudoku.block);
        for(var i = 0; i < sudoku.block; i++){
            this.cellCache[i] = new Array(sudoku.block);

            this.rowArray[i] = new Array(sudoku.block);
            this.colArray[i] = new Array(sudoku.block);
            this.blockArray[i] = new Array(sudoku.block);
            for(var j = 0; j < sudoku.block; j++){
                this.cellCache[i][j] = null;

                this.rowArray[i][j] = null;
                this.colArray[i][j] = null;
                this.blockArray[i][j] = null;
            }
        }

        this.numberCountArray = new Array(sudoku.block);    //出现的数字计数器，一维数组
        this.initNumberKey();   //固定的，可以先初始化
        this.initGame();
    },

    initGame(){
        this.lastClickKey = 0;
        this.lastClickCell = null;
        this.dialogType = 1;        // 1:点击弹出，暂停，2：失败弹出，3：成功弹出
        this.errorCount = 0;        // 错误次数
        this.usedSecond = 0;        // 已用秒
        this.sceneInfo = GameLib.getInfo(PlayerData.param.sceneType, PlayerData.param.sceneIndex);      // 关卡信息
        if(!this.sceneInfo){
            cc.log("场景信息不存在：" + PlayerData.param.sceneType + " - " + PlayerData.param.sceneIndex);
            return;
        }
        this.obtainGold = this.sceneInfo.maxGold;   //获得的金币

        for(var i = 0; i < this.numberArray.length; i++){
            this.numberArray[i] = null;
        }

        this.initTopTitle();
        this.initChessboard();
        this.initNumberCount();

        cc.log("game_ : " + JSON.stringify(sudoku.game) + ",");
        cc.log("full_ : " + JSON.stringify(sudoku.fullGame) + ",");

    },

    initTopTitle(){
        //初始化关卡信息
        this.sceneLab.string = GameLib.getInfo(PlayerData.param.sceneType).name + " " + PlayerData.param.sceneIndex;
        //初始化金币
        this.goldLab.string = this.obtainGold;
        //初始化错误次数
        this.updateErrorCount();
        //初始化计时器
        this.clockNode.getComponent(cc.Label).unscheduleAllCallbacks();
        this.initClock();

        //初始化难度星级
        // var starNumber = this.sceneInfo.maxStar;
        // for(var i = 0; i < starNumber; i++){
        //     var x = 30*((starNumber-1)/2 - i);
        //     var newNode = cc.instantiate(this.levelStarNode);
        //     newNode.parent = this.levelStarNode.parent;
        //     newNode.setPosition(x, -80);
        // }
    },

    initClock(){
        var second = this.sceneInfo.time * 60;
        var sec = second % 60;
        var min = parseInt(second / 60);
        this.clockNode.getComponent(cc.Label).string = (min < 10 ? "0" + min : "" + min) + ":" + (sec < 10 ? "0" + sec : "" + sec);
        this.clockNode.getComponent(cc.Label).schedule(()=>{
            this.usedSecond++;
            if(this.sceneInfo.time > 0){
                second--;
            }else{
                second++;
            }
            sec = second % 60;
            min = parseInt(second / 60);
            this.clockNode.getComponent(cc.Label).string = (min < 10 ? "0" + min : "" + min) + ":" + (sec < 10 ? "0" + sec : "" + sec);

            if(second == 0){
                this.clockNode.getComponent(cc.Label).unscheduleAllCallbacks();
                this.showDialog(2);     //时间到了失败
            }
        }, 1);
    },

    initChessboard(){
        if(!PlayerData.param.sceneType || PlayerData.param.sceneType == 0){
            sudoku.randomInit();
            // sudoku.create(PlayerData.player.scene.challenge.level);
            sudoku.create(43);
        }else{
            sudoku.fixedInit(PlayerData.param.sceneType, PlayerData.param.sceneIndex);
        }

        for(var i = 0; i < sudoku.game.length; i++){
            for(var j = 0; j < sudoku.game[i].length; j++){
                var cell = this.cellCache[i][j];
                if(cell == null){
                    cell = cc.instantiate(this.cellPrefab);
                    var px = BOARD_CELL_SIZE*(j - BOARD_RADIUS) + Math.round((j - BOARD_RADIUS)/BLOCK_SIZE)*3;
                    var py = BOARD_CELL_SIZE*(BOARD_RADIUS - i) + Math.round((BOARD_RADIUS - i)/BLOCK_SIZE)*3;
                    cell.setPosition(cc.v2(px, py));
                    cell.on(cc.Node.EventType.TOUCH_END, this.boardCellClick, this);

                    //额外添加属性
                    cell._row = i;
                    cell._col = j;
                    cell._block = sudoku.getBlock(i, j);
                    this.chessboardNode.addChild(cell);

                    this.cellCache[i][j] = cell;
                    this.rowArray[cell._row][j] = cell;
                    this.colArray[cell._col][i] = cell;
                    var blockIndex = (i % BLOCK_SIZE) * BLOCK_SIZE + j % BLOCK_SIZE;
                    this.blockArray[cell._block][blockIndex] = cell;
                }

                cell._value = sudoku.game[i][j];
                if(sudoku.game[i][j] == 0){
                    cell.getChildByName("number").color = BOARD_CELL_TEXT_COLOR_CANEDIT;
                    cell.getChildByName("number").getComponent(cc.Label).string = '';
                    cell._edit = true;
                }else{
                    cell.getChildByName("number").color = BOARD_CELL_TEXT_COLOR_READONLY;
                    cell.getChildByName("number").getComponent(cc.Label).string = sudoku.game[i][j];
                    cell._edit = false;
                }
                cell.color = BOARD_CELL_COLOR_INIT;

                if(!this.numberArray[cell._value]){
                    this.numberArray[cell._value] = [];
                }
                this.numberArray[cell._value].push(cell);
            }
        }
    },

    initNumberKey(){
        for(var i = 0; i < sudoku.block; i++){
            var cell = cc.instantiate(this.cellPrefab);
            var px = BOARD_CELL_SIZE*(i - BOARD_RADIUS);
            var py = 0;
            cell.setPosition(cc.v2(px, py));
            cell._value = i + 1;
            cell.color = KEY_COLOR_INIT;
            var cellLab = cell.getChildByName("number").getComponent(cc.Label);
            cellLab.string = cell._value;

            cell.on(cc.Node.EventType.TOUCH_END, this.numberKeyClick, this);
            this.numberKeyNode.addChild(cell);

            var cellCount = cc.instantiate(this.cellPrefab);
            cellCount.setPosition(cc.v2(px, py));
            cellCount.color = KEY_COLOR_INIT;
            var celllCountLab = cellCount.getChildByName("number").getComponent(cc.Label);
            celllCountLab.fontSize = 20;
            this.numberCountNode.addChild(cellCount);

            this.numberCountArray[i] = cellCount;
        }
    },

    initNumberCount(){
        for(var i = 0; i < sudoku.block; i++){
            var cellCount = this.numberCountArray[i];
            cellCount.getChildByName("number").getComponent(cc.Label).string = COUNT_TYPE == 1 ? 0 : 9;
        }

        for(var i = 0; i < sudoku.block; i++){
            for(var j = 0; j < sudoku.block; j++){
                var n = sudoku.game[i][j];
                if(n == 0){
                    continue;
                }

                var countNode = this.numberCountArray[n - 1];
                var count = parseInt(countNode.getChildByName("number").getComponent(cc.Label).string);
                countNode.getChildByName("number").getComponent(cc.Label).string = (COUNT_TYPE == 1 ? count + 1 : count -1);
            }
        }
    },

    boardCellClick(event){
        var clickCell = event.target;
        if(clickCell == this.lastClickCell){
            return;
        }

        //先清除之前的颜色
        this.clearLastColor();

        //再重新改变颜色
        this.setBlockCellColor(clickCell);

        //改变与单元格相同数字单元格颜色
        if(clickCell._value != 0){
            var clickCellNumberArray = this.numberArray[clickCell._value];
            for(var i = 0; i < clickCellNumberArray.length; i++){
                clickCellNumberArray[i].color = BOARD_CELL_COLOR_SAMENUMBER;
            }
            if(clickCell._edit){
                clickCell.color = BOARD_CELL_COLOR_EDIT;
            }
        }

        this.checkCellError(clickCell);

        this.lastClickCell = clickCell;
        this.lastClickKey = clickCell._value;
    },

    numberKeyClick(event){
        var clickNode = event.target;
        var keyNumber = clickNode._value;
        if(this.lastClickKey == keyNumber){
            return;
        }

        var currentNumberArray = this.numberArray[keyNumber];
        if(!currentNumberArray){
            currentNumberArray = [];
            this.numberArray[keyNumber] = currentNumberArray;
        }

        //在棋盘填入数字
        //TODO 1、可以加技能判断，技能如果填的数字正确，此格变为不能更改
        if(this.lastClickCell != null && this.lastClickCell._edit == true){
            var lastNumberArray = this.numberArray[this.lastClickCell._value];
            var lastValue = this.lastClickCell._value;
            //删除颜色
            if(this.lastClickCell._value != 0){
                for(var i = 0; i < lastNumberArray.length; i++){
                    lastNumberArray[i].color = BOARD_CELL_COLOR_INIT;
                    lastNumberArray[i].opacity = BOARD_CELL_OPACITY_INIT;
                }
            }
            //恢复宫内颜色
            this.setBlockCellColor(this.lastClickCell);

            //从之前的数字数组删除
            var lastIndex = lastNumberArray.indexOf(this.lastClickCell);
            if( lastIndex != -1){
                lastNumberArray.splice(lastIndex, 1);
            }

            //添加到新数字的数组
            this.lastClickCell._value = keyNumber;
            this.lastClickCell.getChildByName("number").getComponent(cc.Label).string = keyNumber;
            //填入数字正确后，单元格变为只读
            if(keyNumber == sudoku.fullGame[this.lastClickCell._row][this.lastClickCell._col]){
                this.lastClickCell._edit = false;
                this.lastClickCell.getChildByName("number").color = BOARD_CELL_TEXT_COLOR_READONLY;

                //检查是否完成
                this.checkFinish();
            }else{
                //错误增加错误次数
                this.errorCount++;
                this.updateErrorCount();
                if(this.errorCount >= this.sceneInfo.maxError){
                    this.showDialog(2);
                }
            }
            currentNumberArray.push(this.lastClickCell);

            this.updateNumberCount(keyNumber, lastValue);
        }else{
            //先清除之前的颜色
            this.clearLastColor();
            this.lastClickCell = null;
        }

        //和改变相同数字的颜色
        for(var i = 0; i < currentNumberArray.length; i++){
            if(currentNumberArray[i] == this.lastClickCell){
                continue;
            }
            currentNumberArray[i].color = BOARD_CELL_COLOR_SAMENUMBER;
        }

        this.checkCellError(clickNode);
        this.lastClickKey = keyNumber;

    },

    //清除之前的颜色
    clearLastColor(){
        if(this.lastClickCell != null){
            var clickCellBlockArray = this.blockArray[this.lastClickCell._block];
            for(var i = 0; i < clickCellBlockArray.length; i++){
                clickCellBlockArray[i].color = BOARD_CELL_COLOR_INIT;
                clickCellBlockArray[i].opacity = BOARD_CELL_OPACITY_INIT;
            }

            var clickCellRowArray = this.rowArray[this.lastClickCell._row];
            for(var i = 0; i < clickCellRowArray.length; i++){
                clickCellRowArray[i].color = BOARD_CELL_COLOR_INIT;
                clickCellRowArray[i].opacity = BOARD_CELL_OPACITY_INIT;
            }

            var clickCellColArray = this.colArray[this.lastClickCell._col];
            for(var i = 0; i < clickCellColArray.length; i++){
                clickCellColArray[i].color = BOARD_CELL_COLOR_INIT;
                clickCellColArray[i].opacity = BOARD_CELL_OPACITY_INIT;
            }

            var clickCellNumberArray = this.numberArray[this.lastClickCell._value];
            for(var i = 0; i < clickCellNumberArray.length; i++){
                clickCellNumberArray[i].color = BOARD_CELL_COLOR_INIT;
                clickCellNumberArray[i].opacity = BOARD_CELL_OPACITY_INIT;
            }
        }

        if(this.lastClickKey != 0){
            var lastClickNumberArray = this.numberArray[this.lastClickKey];
            for(var i = 0; i < lastClickNumberArray.length; i++){
                lastClickNumberArray[i].color = BOARD_CELL_COLOR_INIT;
                lastClickNumberArray[i].opacity = BOARD_CELL_OPACITY_INIT;
            }
        }

    },

    setBlockCellColor(clickCell){
        var clickCellBlockArray = this.blockArray[clickCell._block];
        for(var i = 0; i < clickCellBlockArray.length; i++){
            clickCellBlockArray[i].color = BOARD_CELL_COLOR_BLOCK;
        }

        var clickCellRowArray = this.rowArray[clickCell._row];
        for(var i = 0; i < clickCellRowArray.length; i++){
            clickCellRowArray[i].color = BOARD_CELL_COLOR_BLOCK;
        }

        var clickCellColArray = this.colArray[clickCell._col];
        for(var i = 0; i < clickCellColArray.length; i++){
            clickCellColArray[i].color = BOARD_CELL_COLOR_BLOCK;
        }

        if(clickCell._edit){
            clickCell.color = BOARD_CELL_COLOR_EDIT;
        }
    },

    checkCellError(clickNumber){
        if(clickNumber == null || clickNumber._value == 0){
            return;
        }

        var t = this.numberArray[clickNumber._value];
        for(var n = 0; n < t.length; n++){
            var clickCell = t[n];
            var clickCellBlockArray = this.blockArray[clickCell._block];
            for(var i = 0; i < clickCellBlockArray.length; i++){
                if(clickCell != clickCellBlockArray[i] && clickCell._value == clickCellBlockArray[i]._value){
                    clickCellBlockArray[i].color = BOARD_CELL_COLOR_ERROR;
                }
            }

            var clickCellRowArray = this.rowArray[clickCell._row];
            for(var i = 0; i < clickCellRowArray.length; i++){
                if(clickCell != clickCellRowArray[i] && clickCell._value == clickCellRowArray[i]._value){
                    clickCellRowArray[i].color = BOARD_CELL_COLOR_ERROR;
                }
            }

            var clickCellColArray = this.colArray[clickCell._col];
            for(var i = 0; i < clickCellColArray.length; i++){
                if(clickCell != clickCellColArray[i] && clickCell._value == clickCellColArray[i]._value){
                    clickCellColArray[i].color = BOARD_CELL_COLOR_ERROR;
                }
            }
        }

        if(clickNumber._edit){
            clickNumber.color = BOARD_CELL_COLOR_EDIT;
        }
    },

    updateNumberCount(newNumber, oldNumber){
        //填入数字正确后，更新数字出现的次数
        if(newNumber == sudoku.fullGame[this.lastClickCell._row][this.lastClickCell._col]){
            var countNode = this.numberCountArray[newNumber -1];
            var count = parseInt(countNode.getChildByName("number").getComponent(cc.Label).string);
            countNode.getChildByName("number").getComponent(cc.Label).string = COUNT_TYPE == 1 ? count + 1: count - 1;
        }
        //之前是正确的，改错误之后，之前的个数要加回去
        if(oldNumber == sudoku.fullGame[this.lastClickCell._row][this.lastClickCell._col]){
            var countNode = this.numberCountArray[oldNumber -1];
            var count = parseInt(countNode.getChildByName("number").getComponent(cc.Label).string);
            countNode.getChildByName("number").getComponent(cc.Label).string = COUNT_TYPE == 1 ? count -1: count + 1;
        }
    },

    updateErrorCount(){
        this.errorLab.string = "错误: " + this.errorCount + "/" + this.sceneInfo.maxError;
    },

    checkFinish(){
        for(var i = 0; i < this.blockArray.length; i++){
            for(var j = 0; j < this.blockArray[i].length; j++){
                if(this.blockArray[i][j]._edit == true){
                    return false;
                }
            }
        }

        //更新玩家数据
        var infoValue = {};
        infoValue.time = this.usedSecond;
        infoValue.star = GameLib.obtainStar(this.sceneInfo, this.usedSecond, this.errorCount);
        var playerScene = null;
        switch(PlayerData.param.sceneType){
            case 1:
                playerScene = PlayerData.player.scene.easy;
                break;
            case 2:
                playerScene = PlayerData.player.scene.normal;
                break;
            case 3:
                playerScene = PlayerData.player.scene.hard;
                break;
            default:
                playerScene = PlayerData.player.scene.challenge;
                break;
        }
        //只有固定模式才统计获得的星星
        if(PlayerData.param.sceneType == 1 || PlayerData.param.sceneType == 2 || PlayerData.param.sceneType == 3){
            var infoKey = PlayerData.param.sceneIndex;
            if(playerScene[infoKey]){
                //之前的星 小于 现在得到的 星
                if(playerScene[infoKey].star < infoValue.star){
                    playerScene[infoKey] = infoValue;
                }
                //两次星相等，但之前的用时大于 现在的用时
                if(playerScene[infoKey].star == infoValue.star && playerScene[infoKey].time > infoValue.time){
                    playerScene[infoKey] = infoValue;
                }
            }else{
                playerScene[infoKey] = infoValue;
            }

            var total = PlayerData.getTotalStar();
            PlayerData.player.star = total;
        }else{
            playerScene.level++;
        }

        PlayerData.player.gold += this.obtainGold;
        PlayerData.save();  //成功过关自动保存
        this.showDialog(3);
        return true;
    },

    returnClick(){
        this.showDialog(1);
    },

    showDialog(type){
        this.dialogType = type;
        this.dialogNode.x = 0;
        this.updateDialog();
    },

    updateDialog(){
        var dialogSceneInfo = this.dialogNode.getChildByName("title").getComponent(cc.Label);
        var dialogErrorCount = this.dialogNode.getChildByName("error").getComponent(cc.Label);
        var dialogUsedTime = this.dialogNode.getChildByName("useTime").getComponent(cc.Label);
        var dialogGold = this.dialogNode.getChildByName("gold").getComponent(cc.Label);
        var dialogDynamic = this.dialogDynamicBtn.getChildByName("dynamic").getComponent(cc.Label);
        switch(this.dialogType){
            case 1:
                dialogSceneInfo.string = this.sceneLab.string + "  暂停";
                dialogDynamic.string = "返回游戏";
                dialogErrorCount.node.color = DIALOG_TEXT_NORMAL;
                dialogUsedTime.node.color = DIALOG_TEXT_NORMAL;
                break;
            case 2:
                dialogSceneInfo.string = this.sceneLab.string + "  挑战失败";
                dialogDynamic.string = "复    活";
                if(this.errorCount >= this.sceneInfo.maxError){
                    dialogErrorCount.node.color = DIALOG_TEXT_ERROR;
                }else{
                    dialogUsedTime.node.color = DIALOG_TEXT_ERROR;
                }
                break;
            case 3:
                dialogSceneInfo.string = this.sceneLab.string + "  挑战成功";
                dialogDynamic.string = "下个关卡";
                dialogErrorCount.node.color = DIALOG_TEXT_NORMAL;
                dialogUsedTime.node.color = DIALOG_TEXT_NORMAL;
                break;
            default:
                break;
        }

        dialogErrorCount.string = this.errorLab.string;
        dialogGold.string = "x" + this.obtainGold;

        var sec = this.usedSecond % 60;
        var min = parseInt(this.usedSecond / 60);
        dialogUsedTime.string = "用时 " + (min < 10 ? "0" + min : "" + min) + ":" + (sec < 10 ? "0" + sec : "" + sec);

        //star
        var getStar = GameLib.obtainStar(this.sceneInfo, this.usedSecond, this.errorCount);
        for(var i = 0; i < this.sceneInfo.maxStar; i++){
            var name = "star" + i;
            if(i < this.sceneInfo.maxStar - getStar){
                this.dialogNode.getChildByName(name).getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));    // 变灰
            }else{
                this.dialogNode.getChildByName(name).getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-sprite'));    // 恢复
            }
        }
    },

    dialogDynamicClick(){
        switch(this.dialogType){
            //返回游戏
            case 1:
                this.dialogNode.x = -1000;
                break;
            //复活
            case 2:
                this.dialogNode.x = -1000;
                //达到错误次数恢复次数
                if(this.errorCount >= this.sceneInfo.maxError){
                    this.errorCount = 0;
                    this.updateErrorCount();
                }
                //倒计时到了恢复时间
                if(this.sceneInfo.time > 0 && this.usedSecond >=this.sceneInfo.time*60){
                    this.usedSecond = 0;
                    this.initClock();
                }
                break;
            //下个关卡
            case 3:
                this.dialogNode.x = -1000;
                //更新关卡序号
                PlayerData.param.sceneIndex++;
                if(PlayerData.param.sceneType == 1 || PlayerData.param.sceneType == 2){
                    if(GameLib.getInfo(PlayerData.param.sceneType).total < PlayerData.param.sceneIndex){
                        PlayerData.param.sceneType++;
                        PlayerData.param.sceneIndex = 1;
                    }
                }else if(PlayerData.param.sceneType == 3){
                    if(GameLib.getInfo(PlayerData.param.sceneType).total < PlayerData.param.sceneIndex){
                        PlayerData.param.sceneIndex--;
                    }
                }

                this.initGame();
                break;
            default:
                break;
        }
    },

    dialogExitClick(){
        PlayerData.save();
        if(!PlayerData.param.sceneType || PlayerData.param.sceneType == 0){
            cc.director.loadScene("home");
        }else{
            cc.director.preloadScene("gameinfopage", function () {
                cc.director.loadScene("gameinfopage");
            });
        }
    },

    dialogResetClick(){
        cc.log("reset = " + PlayerData.param.sceneType);
        this.initGame();
        this.dialogNode.x = -1000;
    },

    // update (dt) {},
});
