var GameLib = require("gameLib");
var PlayerData = require("playerData");

const PAGE_SIZE = 28;
const ROW_NUM = 4;
cc.Class({
    extends: cc.Component,

    properties: {
        sceneTypeLab: cc.Label,
        scenePrefab: cc.Prefab,
        pageNode: cc.Node,
        starLab: cc.Label,
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
        if(this.currentPage < this.totalPage){
            pageSize = PAGE_SIZE;
        }else{
            pageSize = this.gameInfo.total - (this.totalPage - 1)*PAGE_SIZE;
        }

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
                sceneNode.setPosition((i%ROW_NUM -1)*140 - 70, (240 - parseInt(i/ROW_NUM)*80));

                sceneNode.on(cc.Node.EventType.TOUCH_END, this.clickScene, this);

                this.scenePageArray[i] = sceneNode;
            }

            sceneNode.parent = this.pageNode;
            var sceneIndex = PAGE_SIZE*(this.currentPage - 1) + (i + 1);
            sceneNode._index = sceneIndex;
            sceneNode.getChildByName("scene").getComponent(cc.Label).string = sceneIndex;

            var sceneData = PlayerData.getPlayerSceneData(PlayerData.param.sceneType, sceneIndex);
            if(sceneData){
                var second = sceneData.time;
                var sec = second % 60;
                var min = parseInt(second / 60);
                sceneNode.getChildByName("time").getComponent(cc.Label).string = (min < 10 ? "0" + min : "" + min) + ":" + (sec < 10 ? "0" + sec : "" + sec);

                //star
                var getStar = sceneData.star || 0;
                for(var j = 0; j < getStar; j++){
                    var name = "star" + j;
                    sceneNode.getChildByName(name).getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-sprite'));    //恢复
                }
            }
        }
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
