// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

var sudoku = require("sudoku");

var BOARD_CELL_COLOR_INIT = cc.Color.WHITE;                             //单元格初始颜色
var BOARD_CELL_COLOR_SAMENUMBER = cc.Color.BLACK.fromHEX("#23774B");    //单元格相同数字颜色
var BOARD_CELL_COLOR_BLOCK = cc.Color.BLACK.fromHEX("#8BBBA2");         //单元格同宫同列同行颜色
var BOARD_CELL_COLOR_EDIT = cc.Color.BLACK.fromHEX("#F09559");          //单元格编辑颜色
var BOARD_CELL_COLOR_ERROR = cc.Color.RED;                              //单元格错误颜色

var KEY_COLOR_INIT = cc.Color.BLACK.fromHEX("#1B262E");

cc.Class({
    extends: cc.Component,

    properties: {
        chessboard: cc.Node,
        numberKey: cc.Node,
        numberCount: cc.Node,
        cellPrefab: cc.Prefab,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        this.lastClickKey = 0;
        this.lastClickCell = null;
        this.blockArray = new Array(9);
        this.rowArray = new Array(9);
        this.colArray = new Array(9);
        this.numberArray = new Array(10);

        this.initChessboard();
        this.initNumberKey();
    },

    initChessboard(){
        sudoku.init();
        sudoku.create();

        for(var i = 0; i < sudoku.game.length; i++){
            for(var j = 0; j < sudoku.game[i].length; j++){
                var cell = cc.instantiate(this.cellPrefab);
                var px = 31*(j - 4);
                var py = 31*(4 - i);
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
                this.chessboard.addChild(cell);          //添加到场景

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
        for(var i = 0; i < 9; i++){
            var cell = cc.instantiate(this.cellPrefab);
            var px = 31*(i - 4);
            var py = 0;
            cell.setPosition(cc.v2(px, py));
            cell.color = KEY_COLOR_INIT;
            var cellLab = cell.getChildByName("number").getComponent(cc.Label);
            cellLab.string = i+1;
            cellLab.fontSize = 30;
            this.numberKey.addChild(cell);
            cell.on(cc.Node.EventType.TOUCH_END, this.numberKeyClick, this);


            var cellCount = cc.instantiate(this.cellPrefab);
            cellCount.setPosition(cc.v2(px, py));
            cellCount.color = KEY_COLOR_INIT;
            var celllCountLab = cellCount.getChildByName("number").getComponent(cc.Label);
            celllCountLab.string = 0;
            celllCountLab.fontSize = 15;
            this.numberCount.addChild(cellCount);
        }
    },

    boardCellClick(event){
        var clickCell = event.target;
        // var num = clickCell.getChildByName("number").getComponent(cc.Label).string;
        // if(!num || num == "" || num == "0"){
        //     return;
        // }

        if(clickCell == this.lastClickCell){
            return;
        }

        //先清除之前的颜色
        this.clearLastColor();

        //再重新改变颜色
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

        if(clickCell._value != 0){
            var clickCellNumberArray = this.numberArray[clickCell._value];
            for(var i = 0; i < clickCellNumberArray.length; i++){
                clickCellNumberArray[i].color = BOARD_CELL_COLOR_SAMENUMBER;
            }
        }

        if(clickCell._edit){
            clickCell.color = BOARD_CELL_COLOR_EDIT;
        }

        this.lastClickCell = clickCell;
        this.lastClickKey = clickCell._value;
    },

    numberKeyClick(event){
        var clickNode = event.target;
        var number = parseInt(clickNode.getChildByName("number").getComponent(cc.Label).string);
        if(this.lastClickKey == number){
            return;
        }

        //TODO 1、可以加技能判断，技能如果填的数字正确，此格变为不能更改
        if(this.lastClickCell != null && this.lastClickCell._edit == true){
            var lastNumberArray = this.numberArray[this.lastClickCell._value];
            //删除颜色
            if(this.lastClickCell._value != 0){
                for(var i = 0; i < lastNumberArray.length; i++){
                    lastNumberArray[i].color = BOARD_CELL_COLOR_INIT;
                    lastNumberArray[i].opacity = 180;
                }
            }
            //从之前的数组删除
            var lastIndex = lastNumberArray.indexOf(this.lastClickCell);
            if( lastIndex != -1){
                lastNumberArray.splice(lastIndex, 1);
            }
            this.lastClickCell._value = number;
            this.lastClickCell.getChildByName("number").getComponent(cc.Label).string = number;
            //添加
            var currentNumberArray = this.numberArray[number];
            currentNumberArray.push(this.lastClickCell);
        }else{
            //先清除之前的颜色
            this.clearLastColor();
            this.lastClickCell = null;
        }

        var clickNumberArray = this.numberArray[number];
        if(clickNumberArray){
            for(var i = 0; i < clickNumberArray.length; i++){
                clickNumberArray[i].color = BOARD_CELL_COLOR_SAMENUMBER;
            }
        }else{
            this.numberArray[number] = [];
        }

        this.lastClickKey = number;
    },

    //清除之前的颜色
    clearLastColor(){
        if(this.lastClickCell != null){
            var clickCellBlockArray = this.blockArray[this.lastClickCell._block];
            for(var i = 0; i < clickCellBlockArray.length; i++){
                clickCellBlockArray[i].color = BOARD_CELL_COLOR_INIT;
                clickCellBlockArray[i].opacity = 180;
            }

            var clickCellRowArray = this.rowArray[this.lastClickCell._row];
            for(var i = 0; i < clickCellRowArray.length; i++){
                clickCellRowArray[i].color = BOARD_CELL_COLOR_INIT;
                clickCellRowArray[i].opacity = 180;
            }

            var clickCellColArray = this.colArray[this.lastClickCell._col];
            for(var i = 0; i < clickCellColArray.length; i++){
                clickCellColArray[i].color = BOARD_CELL_COLOR_INIT;
                clickCellColArray[i].opacity = 180;
            }

            var clickCellNumberArray = this.numberArray[this.lastClickCell._value];
            for(var i = 0; i < clickCellNumberArray.length; i++){
                clickCellNumberArray[i].color = BOARD_CELL_COLOR_INIT;
                clickCellNumberArray[i].opacity = 180;
            }
        }

        if(this.lastClickKey != 0){
            var lastClickNumberArray = this.numberArray[this.lastClickKey];
            for(var i = 0; i < lastClickNumberArray.length; i++){
                lastClickNumberArray[i].color = BOARD_CELL_COLOR_INIT;
                lastClickNumberArray[i].opacity = 180;
            }
        }

    },
    // update (dt) {},
});
