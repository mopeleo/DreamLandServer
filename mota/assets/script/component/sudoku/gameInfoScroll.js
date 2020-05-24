var GameLib = require("gameLib");
var PlayerData = require("playerData");

cc.Class({
    extends: cc.Component,

    properties: {
        level: cc.Label,
        scenePrefab: cc.Prefab,
        scrollContent: cc.Node,
    },

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
        for(var i = 0; i < this.gameInfo.total; i++){
            var sceneNode = cc.instantiate(this.scenePrefab);
            this.scrollContent.addChild(sceneNode);
            sceneNode.on(cc.Node.EventType.TOUCH_END, this.clickScene, this);

            sceneNode._index = i+1;
            sceneNode.getChildByName("scene").getComponent(cc.Label).string = "关卡 " + sceneNode._index;

            var sceneData = PlayerData.getPlayerSceneData(PlayerData.param.sceneType, i+1);
            if(sceneData){
                var second = sceneData.time;
                var sec = second % 60;
                var min = parseInt(second / 60);
                sceneNode.getChildByName("time").getComponent(cc.Label).string = "用时 " + (min < 10 ? "0" + min : "" + min) + ":" + (sec < 10 ? "0" + sec : "" + sec);

                //star
                var getStar = sceneData.star;
                var greyStar = this.gameInfo["info_" + (i+1)].maxStar - getStar;
                for(var i = 0; i < greyStar; i++){
                    var name = "star" + i;
                    sceneNode.getChildByName(name).getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));    // 变灰
                }
            }
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
