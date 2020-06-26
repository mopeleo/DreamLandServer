var GameLib = require("../common/gameLib");
var PlayerData = require("../common/playerData");

const PAGE_SIZE = 16;
const ROW_NUM = 4;
cc.Class({
    extends: cc.Component,

    properties: {
        itemPrefab: cc.Prefab,
        pageNode: cc.Node,
        pageLab: cc.Label,
        nextBtn: cc.Node,
        preBtn: cc.Node,
    },

    onLoad () {
        this.itemKeys = Object.keys(GameLib.item);

        this.totalPage = parseInt(this.itemKeys.length/PAGE_SIZE) + (this.itemKeys.length%PAGE_SIZE == 0 ? 0: 1);
        this.currentPage = 1;
        this.pageLab.string = this.currentPage + "/" + this.totalPage;

        this.preBtn.on(cc.Node.EventType.TOUCH_END, this.prePage, this);
        this.nextBtn.on(cc.Node.EventType.TOUCH_END, this.nextPage, this);

        this.itemPageArray = new Array(PAGE_SIZE);
        this.initItemList();
    },

    initItemList(){
        var pageSize = 0;
        if(this.currentPage < this.totalPage){
            pageSize = PAGE_SIZE;
        }else{
            pageSize = this.itemKeys.length - (this.totalPage - 1)*PAGE_SIZE;
            // pageSize = 16;
        }

        cc.loader.loadResDir(GameLib.itemDir, cc.SpriteFrame, (err, texture, urls)=>{
            for(var i = 0; i < PAGE_SIZE; i++){
                var itemNode = this.itemPageArray[i];
                if(i > (pageSize-1)){
                    if(itemNode){
                        itemNode.parent = null;
                    }
                    continue;
                }

                var itemId = this.itemKeys[i*this.currentPage];
                var itemObj = GameLib.item[itemId];
                if(!itemNode){
                    itemNode = cc.instantiate(this.itemPrefab);
                    itemNode.setPosition((i%ROW_NUM -1)*160 - 80, (250 - parseInt(i/ROW_NUM)*170));
                    itemNode.on(cc.Node.EventType.TOUCH_END, this.clickItem, this);

                    this.itemPageArray[i] = itemNode;
                }

                itemNode.parent = this.pageNode;
                itemNode._itemId = itemId;
                itemNode.getChildByName("itemSprite").getComponent(cc.Sprite).spriteFrame = cc.loader.getRes(GameLib.itemDir + itemId, cc.SpriteFrame);

                var priceNode = itemNode.getChildByName("priceNode");
                priceNode.getChildByName("itemPrice").getComponent(cc.Label).string = itemObj.price;
            }
        });
    },

    clickItem(event){
        var clickNode = event.target;
    },

    nextPage(){
        if(this.currentPage < this.totalPage){
            this.currentPage++;
            this.pageLab.string = this.currentPage + "/" + this.totalPage;
        }
        this.initItemList();
    },

    prePage(){
        if(this.currentPage > 1){
            this.currentPage--;
            this.pageLab.string = this.currentPage + "/" + this.totalPage;
        }
        this.initItemList();
    },

    gotoHome(){
        cc.director.loadScene("home");
    },
});
