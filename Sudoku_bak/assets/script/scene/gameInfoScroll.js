var GameLib = require("../common/gameLib");
var PlayerData = require("../common/playerData");

cc.Class({
    extends: cc.Component,

    properties: {
        sceneTypeLab: cc.Label,
        starLab: cc.Label,
        scenePrefab: cc.Prefab,
        scrollContent: cc.Node,
    },

    onLoad () {
        this.gameInfo = GameLib.getInfo(PlayerData.param.sceneType);
        this.sceneTypeLab.string = this.gameInfo.name;
        this.starLab.string =  PlayerData.getTotalStar(PlayerData.param.sceneType) + "/" + this.gameInfo.total*3;

        this.initSceneList();
    },

    initSceneList(){
        for(var i = 0; i < this.gameInfo.total; i++){
            var sceneNode = cc.instantiate(this.scenePrefab);
            this.scrollContent.addChild(sceneNode);
            sceneNode.on(cc.Node.EventType.TOUCH_END, this.clickScene, this);

            sceneNode._index = i+1;
            var mask = sceneNode.getChildByName("mask");
            mask.getChildByName("scene").getComponent(cc.Label).string = sceneNode._index;

            var sceneData = PlayerData.getPlayerSceneData(PlayerData.param.sceneType, i+1);
            if(sceneData){
                var second = sceneData.time;
                var sec = second % 60;
                var min = parseInt(second / 60);
                mask.getChildByName("time").getComponent(cc.Label).string = (min < 10 ? "0" + min : "" + min) + ":" + (sec < 10 ? "0" + sec : "" + sec);

                //star
                var getStar = sceneData.star;
                var greyStar = this.gameInfo["info_" + (i+1)].maxStar - getStar;
                for(var i = 0; i < greyStar; i++){
                    var name = "star" + i;
                    mask.getChildByName(name).getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));    // 变灰
                }
            }
        }
    },

    clickScene(event){
        var clickNode = event.target;
        PlayerData.param.sceneIndex = clickNode._index;
        cc.director.loadScene("chessboard");
    },

    test () {
        Dialog.show("如果你对A股还抱有幻想，那么请看我举的一个例子：学霸可能会偶尔失手，但差等生永远都不会得第一");
    },

    gotoHome(){
        cc.director.loadScene("home");
    },
    // update (dt) {},
});
