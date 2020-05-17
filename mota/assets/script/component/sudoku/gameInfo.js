// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

var GameLib = require("gameLib");
var PlayerData = require("playerData");

cc.Class({
    extends: cc.Component,

    properties: {
        level: cc.Label,
        scenePrefab: cc.Prefab,
        scrollContent: cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        this.gameInfo = null;
        switch(PlayerData.param.sceneType){
            case 1:
                this.gameInfo = GameLib.easy;
                break;
            case 2:
                this.gameInfo = GameLib.normal;
                break;
            case 3:
                this.gameInfo = GameLib.hard;
                break;
            default:
                this.gameInfo = GameLib.easy;
                break;
        }
        this.level.string = this.gameInfo.name;

        this.initSceneList();
    },

    initSceneList(){

        var row_num = 3;
        for(var i = 0; i < this.gameInfo.total; i++){
            var sceneNode = cc.instantiate(this.scenePrefab);
            // sceneNode.setPosition((i%row_num -1)*200, (350 - parseInt(i/row_num)*80));
            // sceneNode.parent = this.node;

            // sceneNode.setPosition((i%row_num -1)*200, (0 - parseInt(i/row_num)*80));
            this.scrollContent.addChild(sceneNode);

            sceneNode._index = i+1;
            sceneNode.getChildByName("scene").getComponent(cc.Label).string = "关卡 " + sceneNode._index;
            var info = this.gameInfo["info_" + sceneNode._index];

            sceneNode.on(cc.Node.EventType.TOUCH_END, this.clickScene, this);
        }
    },

    clickScene(event){
        var clickNode = event.target;
        PlayerData.param.sceneIndex = clickNode._index;
        cc.director.loadScene("chessboard");
    },

    start () {
    },

    gotoHome(){
        cc.director.loadScene("home");
    },
    // update (dt) {},
});
