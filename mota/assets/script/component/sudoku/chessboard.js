// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

var sudoku = require("sudoku");
var GameLib = require("gameLib");
var PlayerData = require("playerData");

var BOARD_CELL_COLOR_INIT = cc.Color.WHITE;                             //单元格初始颜色
var BOARD_CELL_COLOR_SAMENUMBER = cc.Color.BLACK.fromHEX("#23774B");    //单元格相同数字颜色
var BOARD_CELL_COLOR_BLOCK = cc.Color.BLACK.fromHEX("#8BBBA2");         //单元格同宫同列同行颜色
var BOARD_CELL_COLOR_EDIT = cc.Color.BLACK.fromHEX("#F09559");          //单元格编辑颜色
var BOARD_CELL_COLOR_ERROR = cc.Color.RED;                              //单元格错误颜色
var BOARD_CELL_OPACITY_INIT = 180;                                      //单元格初始透明度

var KEY_COLOR_INIT = cc.Color.BLACK.fromHEX("#1B262E");
var COUNT_TYPE = 1;         //计数器显示类型，1显示数字存在的个数，0显示数字缺失的个数

var BOARD_CELL_SIZE = 65 + 2;                       //单元格大小，+1是每个格子之间的距离为1；
var BOARD_RADIUS = Math.floor(sudoku.block/2);      //棋盘半径，即边到中心（0，0）有多少个格子
var BLOCK_SIZE = Math.sqrt(sudoku.block);           //宫大小 ？*？

cc.Class({
    extends: cc.Component,

    properties: {
        chessboard: cc.Node,
        numberKey: cc.Node,
        numberCount: cc.Node,
        clockNode: cc.Node,
        cellPrefab: cc.Prefab,
        levelStar: cc.Node,
        sceneLab: cc.Label,
        goldLab: cc.Label,
        errorLab: cc.Label,
        dialog: cc.Node,
        dialogDynamicBtn: cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        this.lastClickKey = 0;
        this.lastClickCell = null;
        this.rowArray = new Array(sudoku.block);
        this.colArray = new Array(sudoku.block);
        this.blockArray = new Array(sudoku.block);
        this.numberArray = new Array(sudoku.block + 1);
        this.numberCountArray = new Array(sudoku.block);
        this.dialogType = 1;        // 1:点击弹出，暂停，2：失败弹出，3：成功弹出
        this.errorCount = 0;        // 错误次数
        this.usedSecond = 0;        // 已用秒
        this.sceneInfo = GameLib.getInfo(PlayerData.param.sceneType, PlayerData.param.sceneIndex);      // 关卡信息

        this.initChessboard();
        this.initNumberKey();

        this.initTopTitle();

        //初始话对话框
        this.dialog.on(cc.Node.EventType.TOUCH_START,function(event){
            event.stopPropagation();
        });
        this.dialog.on(cc.Node.EventType.TOUCH_END, function (event) {
            event.stopPropagation();
        });

    },

    initTopTitle(){
        //初始化关卡信息
        this.sceneLab.string = GameLib.getInfo(PlayerData.param.sceneType).name + " " + PlayerData.param.sceneIndex;
        //初始化金币
        this.goldLab.string = this.sceneInfo.maxGold;
        //初始化错误次数
        this.updateErrorCount();
        //初始化计时器
        this.initClock();

        //初始化难度星级
        var starNumber = this.sceneInfo.maxStar;
        for(var i = 0; i < starNumber; i++){
            var x = 30*((starNumber-1)/2 - i);
            var newNode = cc.instantiate(this.levelStar);
            newNode.parent = this.levelStar.parent;
            newNode.setPosition(x, -80);
        }
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
            sudoku.create(PlayerData.player.scene.challenge.level);
        }else{
            sudoku.fixedInit(PlayerData.param.sceneType, PlayerData.param.sceneIndex);
        }

        for(var i = 0; i < sudoku.game.length; i++){
            for(var j = 0; j < sudoku.game[i].length; j++){
                var cell = null;
                cell = cc.instantiate(this.cellPrefab);
                var px = BOARD_CELL_SIZE*(j - BOARD_RADIUS) + Math.round((j - BOARD_RADIUS)/BLOCK_SIZE)*3;
                var py = BOARD_CELL_SIZE*(BOARD_RADIUS - i) + Math.round((BOARD_RADIUS - i)/BLOCK_SIZE)*3;
                cell.setPosition(cc.v2(px, py));

                if(sudoku.game[i][j] == 0){
                    cell._edit = true;
                }else{
                    cell.getChildByName("number").color = cc.Color.BLACK;
                    cell.getChildByName("number").getComponent(cc.Label).string = sudoku.game[i][j];
                    cell._edit = false;
                }
                cell.on(cc.Node.EventType.TOUCH_END, this.boardCellClick, this);

                //额外添加属性
                cell._row = i;
                cell._col = j;
                cell._block = sudoku.getBlock(i, j);
                cell._value = sudoku.game[i][j];
                this.chessboard.addChild(cell);

                if(!this.blockArray[cell._block]){
                    this.blockArray[cell._block] = [];
                }
                this.blockArray[cell._block].push(cell);

                if(!this.rowArray[cell._row]){
                    this.rowArray[cell._row] = [];
                }
                this.rowArray[cell._row].push(cell);

                if(!this.colArray[cell._col]){
                    this.colArray[cell._col] = [];
                }
                this.colArray[cell._col].push(cell);

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
            this.numberKey.addChild(cell);
            cell.on(cc.Node.EventType.TOUCH_END, this.numberKeyClick, this);

            var cellCount = cc.instantiate(this.cellPrefab);
            cellCount.setPosition(cc.v2(px, py));
            cellCount.color = KEY_COLOR_INIT;
            var celllCountLab = cellCount.getChildByName("number").getComponent(cc.Label);
            celllCountLab.string = COUNT_TYPE == 1 ? 0 : 9;
            celllCountLab.fontSize = 30;
            this.numberCount.addChild(cellCount);

            this.numberCountArray[i] = cellCount;
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
                this.lastClickCell.getChildByName("number").color = cc.Color.BLACK;

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

        this.showDialog(3);
        PlayerData.save();  //成功过关自动保存
        return true;
    },

    returnClick(){
        this.showDialog(1);
    },

    showDialog(type){
        this.dialogType = type;
        this.dialog.x = 0;
        this.updateDialog();
    },

    updateDialog(){
        var dialogSceneInfo = this.dialog.getChildByName("title").getComponent(cc.Label);
        var dialogErrorCount = this.dialog.getChildByName("error").getComponent(cc.Label);
        var dialogUsedTime = this.dialog.getChildByName("useTime").getComponent(cc.Label);
        var dialogGold = this.dialog.getChildByName("gold").getComponent(cc.Label);
        var dialogDynamic = this.dialogDynamicBtn.getChildByName("dynamic").getComponent(cc.Label);
        switch(this.dialogType){
            case 1:
                dialogSceneInfo.string = this.sceneLab.string + "  暂停";
                dialogDynamic.string = "返回游戏";
                dialogErrorCount.node.color = BOARD_CELL_COLOR_INIT;
                dialogUsedTime.node.color = BOARD_CELL_COLOR_INIT;
                break;
            case 2:
                dialogSceneInfo.string = this.sceneLab.string + "  挑战失败";
                dialogDynamic.string = "复    活";
                if(this.errorCount >= this.sceneInfo.maxError){
                    dialogErrorCount.node.color = BOARD_CELL_COLOR_ERROR;
                }else{
                    dialogUsedTime.node.color = BOARD_CELL_COLOR_ERROR;
                }
                break;
            case 3:
                dialogSceneInfo.string = this.sceneLab.string + "  挑战成功";
                dialogDynamic.string = "下个关卡";
                dialogErrorCount.node.color = BOARD_CELL_COLOR_INIT;
                dialogUsedTime.node.color = BOARD_CELL_COLOR_INIT;
                break;
            default:
                break;
        }
        // this.dialogDynamicBtn.on(cc.Node.EventType.TOUCH_END, this.dialogDynamicClick, this);

        dialogErrorCount.string = this.errorLab.string;
        dialogGold.string = "x" + this.goldLab.string;

        var sec = this.usedSecond % 60;
        var min = parseInt(this.usedSecond / 60);
        dialogUsedTime.string = "用时 " + (min < 10 ? "0" + min : "" + min) + ":" + (sec < 10 ? "0" + sec : "" + sec);
    },

    dialogDynamicClick(){
        cc.log("dialogType = " + this.dialogType);
        switch(this.dialogType){
            //返回游戏
            case 1:
                this.dialog.x = -1000;
                break;
            //复活
            case 2:
                this.dialog.x = -1000;
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
                this.dialog.x = -1000;
                PlayerData.param.sceneIndex++;
                break;
            default:
                break;
        }
    },

    dialogExistClick(){
        sudoku.again();
        PlayerData.save();
        if(!PlayerData.param.sceneType || PlayerData.param.sceneType == 0){
            cc.director.loadScene("home");
        }else{
            cc.director.preloadScene("gameinfo", function () {
                cc.director.loadScene("gameinfo");
            });
        }
    },

    dialogResetClick(){
        cc.log("reset = " + PlayerData.param.sceneType);

    },

    // update (dt) {},
});
