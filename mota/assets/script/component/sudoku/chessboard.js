// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

var sudoku = require("sudoku");

var color = cc.Color.BLACK;
var BOARD_INIT_COLOR = cc.Color.WHITE;
// var BOARD_CLICK_CELL_COLOR = color.fromHEX("#1A6936");
var BOARD_CLICK_CELL_COLOR = cc.Color.RED;
var NUMBERKEY_INIT_COLOR = color.fromHEX("#1B262E");

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
        this.lastClickNumber = 0;
        this.blockArray = new Array(9);
        this.rowArray = new Array(9);
        this.colArray = new Array(9);
        this.numberArray = new Array(10);

        this.initChessboard();
        this.initNumberKey();
    },

    start () {

    },

    initChessboard(){
        sudoku.init();
        // sudoku.create();

        for(var i = 0; i < sudoku.game.length; i++){
            for(var j = 0; j < sudoku.game[i].length; j++){
                var cell = cc.instantiate(this.cellPrefab);
                var px = 31*(j - 4);
                var py = 31*(4 - i);
                cell.setPosition(cc.v2(px, py));
                if(sudoku.game[i][j] == 0){
                    cell.getChildByName("number").getComponent(cc.Label).string = "";
                }else{
                    cell.getChildByName("number").color = cc.Color.BLACK;
                    cell.getChildByName("number").getComponent(cc.Label).string = sudoku.game[i][j];
                }
                cell.on(cc.Node.EventType.TOUCH_END, this.numberCellClick, this);

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
            cell.color = NUMBERKEY_INIT_COLOR;
            var cellLab = cell.getChildByName("number").getComponent(cc.Label);
            cellLab.string = i+1;
            cellLab.fontSize = 30;
            this.numberKey.addChild(cell);
            cell.on(cc.Node.EventType.TOUCH_END, this.numberKeyClick, this);


            var cellCount = cc.instantiate(this.cellPrefab);
            cellCount.setPosition(cc.v2(px, py));
            cellCount.color = NUMBERKEY_INIT_COLOR;
            var celllCountLab = cellCount.getChildByName("number").getComponent(cc.Label);
            celllCountLab.string = 0;
            celllCountLab.fontSize = 15;
            this.numberCount.addChild(cellCount);
        }
    },

    numberCellClick(event){
        var num = event.target.getChildByName("number").getComponent(cc.Label).string;
        if(!num || num == "" || num == "0"){
            return;
        }

        this.numberKeyClick(event);
    },

    numberKeyClick(event){
        var clickNode = event.target;
        var number = parseInt(clickNode.getChildByName("number").getComponent(cc.Label).string);
        // cc.log("number = " + number);
        if(this.lastClickNumber == number){
            return;
        }
        var clickNumberArray = this.numberArray[number];
        for(var i = 0; i < clickNumberArray.length; i++){
            clickNumberArray[i].color = BOARD_CLICK_CELL_COLOR;
        }

        if(this.lastClickNumber != 0){
            var lastClickNumberArray = this.numberArray[this.lastClickNumber];
            for(var i = 0; i < lastClickNumberArray.length; i++){
                lastClickNumberArray[i].color = BOARD_INIT_COLOR;
                lastClickNumberArray[i].opacity = 180;
            }
        }

        this.lastClickNumber = number;
    },
    // update (dt) {},
});