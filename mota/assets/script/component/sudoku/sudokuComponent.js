// Learn cc.Class:
//  - [Chinese] http://www.cocos.com/docs/creator/scripting/class.html
//  - [English] http://www.cocos2d-x.org/docs/editors_and_tools/creator-chapters/scripting/class/index.html
// Learn Attribute:
//  - [Chinese] http://www.cocos.com/docs/creator/scripting/reference/attributes.html
//  - [English] http://www.cocos2d-x.org/docs/editors_and_tools/creator-chapters/scripting/reference/attributes/index.html
// Learn life-cycle callbacks:
//  - [Chinese] http://www.cocos.com/docs/creator/scripting/life-cycle-callbacks.html
//  - [English] http://www.cocos2d-x.org/docs/editors_and_tools/creator-chapters/scripting/life-cycle-callbacks/index.html

var sudoku = require("sudoku");

cc.Class({
    extends: cc.Component,

    properties: {

        block:{
            default:null,
            type:cc.Sprite
        },

        cellPrefab:{
            default:null,
            type:cc.Prefab
        },


        cellEventFlag:true,  //单元格事件开关
        clickCell:null
    },

    // LIFE-CYCLE CALLBACKS:

    // onLoad () {},

    start () {
        sudoku.init();
        sudoku.create();

        for(var i = 0; i < sudoku.game.length; i++){
            for(var j = 0; j < sudoku.game[i].length; j++){
                var cell = cc.instantiate(this.cellPrefab);
                var px = 30*(j - 4);
                var py = 30*(4 - i);
                //调整对齐像素
                if(px > 0){
                    px++;
                }
                if(px < 0){
                    px--;
                }
                if(py > 0){
                    py++;
                }
                if(py < 0){
                    py--;
                }
                cell.setPosition(cc.v2(px, py));
                if(sudoku.game[i][j] == 0){
                    cell.getChildByName("number").getComponent(cc.Label).string = " ";
                    cell.on(cc.Node.EventType.TOUCH_END, this.clickCellEvent, this);
                }else{
                    cell.getChildByName("number").color = cc.Color.BLACK;
                    cell.getChildByName("number").getComponent(cc.Label).string = sudoku.game[i][j];
                }

                //额外添加属性
                cell._row = i;
                cell._col = j;
                cell._block = sudoku.getBlock(i, j);
                this.block.node.addChild(cell);          //添加到场景
            }
        }
    },

    clickCellEvent: function(event){
        var color = cc.Color.BLACK;
        if(this.cellEventFlag){
            this.cellEventFlag = false;
            this.clickCell = event.target;
            this.clickCell.color = color.fromHEX("#D4D533");
        }else{
            this.cellEventFlag = true;
            this.clickCell.color = color.fromHEX("#FFFFFF");
            this.clickCell = null;
        }
    },

    fillNumberEvent: function(event){
        var clickNum = event.target.getComponent(cc.Label).string;
        this.clickCell.getChildByName("number").getComponent(cc.Label).string = clickNum;
        // this.clickCell.on(cc.Node.EventType.TOUCH_END, this.clickCellEvent, this);
        this.cellEventFlag = true;

        if(sudoku.check(this.clickCell._row, this.clickCell._col, clickNum) != 0){
            this.clickCell.getChildByName("number").color = cc.Color.RED;
        }else{
            this.clickCell.getChildByName("number").color = cc.Color.BLUE;
        }
        sudoku.game[this.clickCell._row][this.clickCell._col] = clickNum;
        sudoku.rowExistNumber[this.clickCell._row][clickNum - 1] = true;
        sudoku.colExistNumber[this.clickCell._col][clickNum - 1] = true;
        sudoku.blockExistNumber[this.clickCell._block][clickNum - 1] = true;


        if(sudoku.finishCheck()){
        }
    },


});
