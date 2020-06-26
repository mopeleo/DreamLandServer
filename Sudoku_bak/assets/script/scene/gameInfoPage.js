var GameLib = require("../common/gameLib");
var PlayerData = require("../common/playerData");

const PAGE_SIZE = 25;
const ROW_NUM = 5;
cc.Class({
    extends: cc.Component,

    properties: {
        sceneTypeLab: cc.Label,
        starLab: cc.Label,
        scenePrefab: cc.Prefab,
        pageNode: cc.Node,
        pageLab: cc.Label,
        nextBtn: cc.Node,
        preBtn: cc.Node,
    },

    onLoad () {
        this.gameInfo = GameLib.getInfo(PlayerData.param.sceneType);
        this.sceneTypeLab.string = this.gameInfo.name;
        this.starLab.string =  PlayerData.getTotalStar(PlayerData.param.sceneType) + "/" + this.gameInfo.total*3;

        this.totalPage = parseInt(this.gameInfo.total/PAGE_SIZE) + (this.gameInfo.total%PAGE_SIZE == 0 ? 0: 1);
        this.currentPage = parseInt(PlayerData.param.sceneIndex/PAGE_SIZE) + (PlayerData.param.sceneIndex%PAGE_SIZE == 0 ? 0: 1);
        if(this.currentPage == 0){
            this.currentPage = 1;
        }
        this.pageLab.string = this.currentPage + "/" + this.totalPage;

        this.preBtn.on(cc.Node.EventType.TOUCH_END, this.prePage, this);
        this.nextBtn.on(cc.Node.EventType.TOUCH_END, this.nextPage, this);

        this.scenePageArray = new Array(PAGE_SIZE);
        this.initSceneList();
    },

    initSceneList(){
        var pageSize = 0;
        var currentIndex = PlayerData.getPlayerCurrentIndex(PlayerData.param.sceneType);
        if(this.currentPage < this.totalPage){
            pageSize = PAGE_SIZE;
        }else{
            pageSize = this.gameInfo.total - (this.totalPage - 1)*PAGE_SIZE;
        }

cc.loader.loadRes("texture/atlas", cc.SpriteAtlas, (err, atlas)=>{
        for(var i = 0; i < PAGE_SIZE; i++){
            var sceneNode = this.scenePageArray[i];
            if(i > (pageSize-1)){
                if(sceneNode){
                    sceneNode.parent = null;
                }
                continue;
            }

            if(!sceneNode){
                sceneNode = cc.instantiate(this.scenePrefab);
                // sceneNode.setPosition((i%ROW_NUM -1)*140 - 70, (240 - parseInt(i/ROW_NUM)*80));         //ovalScene
                sceneNode.setPosition((i%ROW_NUM -1)*130 - 130, (260 - parseInt(i/ROW_NUM)*130));         //cycleLockScene

                sceneNode.on(cc.Node.EventType.TOUCH_END, this.clickScene, this);

                this.scenePageArray[i] = sceneNode;
            }

            sceneNode.parent = this.pageNode;
            var sceneIndex = PAGE_SIZE*(this.currentPage - 1) + (i + 1);
            sceneNode._index = sceneIndex;

            var mask = sceneNode.getChildByName("mask");
            if(sceneIndex > currentIndex + 1){
                //置灰
                var frame = atlas.getSpriteFrame("blank_button_03");
                sceneNode.getComponent(cc.Sprite).spriteFrame = frame;
                sceneNode.off(cc.Node.EventType.TOUCH_END, this.clickScene, this);
                mask.active = false;
            }else{
                //放开
                if(mask.active == false){
                    var frame = atlas.getSpriteFrame("blank_button_02");
                    sceneNode.getComponent(cc.Sprite).spriteFrame = frame;
                    sceneNode.on(cc.Node.EventType.TOUCH_END, this.clickScene, this);
                    mask.active = true;
                }
            }

            mask.getChildByName("scene").getComponent(cc.Label).string = sceneIndex;

            var sceneData = PlayerData.getPlayerSceneData(PlayerData.param.sceneType, sceneIndex);
            if(sceneData){
                var second = sceneData.time;
                var sec = second % 60;
                var min = parseInt(second / 60);
                mask.getChildByName("time").getComponent(cc.Label).string = (min < 10 ? "0" + min : "" + min) + ":" + (sec < 10 ? "0" + sec : "" + sec);

                //star
                var getStar = sceneData.star || 0;
                for(var j = 0; j < getStar; j++){
                    var name = "star" + j;
                    mask.getChildByName(name).getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-sprite'));    //恢复
                }
            }else{
                mask.getChildByName("time").getComponent(cc.Label).string = "00:00";
                for(var j = 0; j < 3; j++){
                    var name = "star" + j;
                    mask.getChildByName(name).getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));    //变灰
                }

            }
        }
});
    },

    clickScene(event){
        var clickNode = event.target;
        PlayerData.param.sceneIndex = clickNode._index;
        cc.director.loadScene("chessboard");
    },

    nextPage(){
        if(this.currentPage < this.totalPage){
            this.currentPage++;
            this.pageLab.string = this.currentPage + "/" + this.totalPage;
        }
        this.initSceneList();
    },

    prePage(){
        if(this.currentPage > 1){
            this.currentPage--;
            this.pageLab.string = this.currentPage + "/" + this.totalPage;
        }
        this.initSceneList();
    },

    gotoHome(){
        cc.director.loadScene("home");
    },
});
