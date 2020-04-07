var pub = require("pubDefine");
var itemData = require("itemDefine");
var enemyData = require("enemyDefine");

cc.Class({
    extends: cc.Component,

    properties: {
        player: cc.Node,
        playerAltas: cc.SpriteAtlas
    },

    // LIFE-CYCLE CALLBACKS:

    // onLoad () {},

    start () {
        //初始化地图位置
        // this.node.setPosition(cc.visibleRect.bottomLeft);
        //地图
        this.tiledMap = this.node.getComponent(cc.TiledMap);
        this.player.getComponent(cc.Sprite).spriteFrame = this.playerAltas.getSpriteFrame("player_0");
        this.title = this.node.parent.getChildByName("title");
        // pub.initFloor(this.tiledMap);
        this.loadMap();
        // cc.systemEvent.on(cc.SystemEvent.EventType.KEY_DOWN, this.onKeyDown, this);
        this.title.getChildByName('up').on(cc.Node.EventType.TOUCH_END, event=>{
            var newTile = cc.v2(this.playerTile.x, this.playerTile.y);
            newTile.y -= 1;
            this.player.getComponent(cc.Sprite).spriteFrame = this.playerAltas.getSpriteFrame("player_5");
            this.tryMoveToNewTile(newTile);
        }, this);
        this.title.getChildByName('down').on(cc.Node.EventType.TOUCH_END, event=>{
            var newTile = cc.v2(this.playerTile.x, this.playerTile.y);
            newTile.y += 1;
            this.player.getComponent(cc.Sprite).spriteFrame = this.playerAltas.getSpriteFrame("player_0");
            this.tryMoveToNewTile(newTile);
        }, this);
        this.title.getChildByName('left').on(cc.Node.EventType.TOUCH_END, event=>{
            var newTile = cc.v2(this.playerTile.x, this.playerTile.y);
            newTile.x -= 1;
            this.tryMoveToNewTile(newTile);
            this.player.getComponent(cc.Sprite).spriteFrame = this.playerAltas.getSpriteFrame("player_1");
        });
        this.title.getChildByName('right').on(cc.Node.EventType.TOUCH_END, event=>{
            var newTile = cc.v2(this.playerTile.x, this.playerTile.y);
            newTile.x += 1;
            this.tryMoveToNewTile(newTile);
            this.player.getComponent(cc.Sprite).spriteFrame = this.playerAltas.getSpriteFrame("player_3");
        });

    },


    onKeyDown:function(event){
        var newTile = cc.v2(this.playerTile.x, this.playerTile.y);
        switch(event.keyCode) {
            case cc.macro.KEY.up:
                newTile.y -= 1;
                break;
            case cc.macro.KEY.down:
                newTile.y += 1;
                break;
            case cc.macro.KEY.left:
                newTile.x -= 1;
                break;
            case cc.macro.KEY.right:
                newTile.x += 1;
                break;
            default:
                return;
        }
        this.tryMoveToNewTile(newTile);
    },


    tryMoveToNewTile: function(newTile) {
        if(pub.player.isBattle){
            return;
        }
        var mapSize = this.tiledMap.getMapSize();
        if (newTile.x < 0 || newTile.x >= mapSize.width) return;
        if (newTile.y < 0 || newTile.y >= mapSize.height) return;

        if (this.wall.getTileGIDAt(newTile)) {//GID=0,则该Tile为空
            cc.log('This way is blocked!');
            // cc.log('pub = ' + JSON.stringify(PUB.getEnemy(1)));
            return;
        }

        if(!this.killEnemy(newTile)){
            cc.log('This enemy is blocked!');
            return;
        }

        if(!itemData.pickItem(this.tiledMap, newTile, pub.player)){
            cc.log('not enough key!');
            return;
        }else{
            pub.refreshTitle(this.title);
        }

        this.playerTile = newTile;
        this.updatePlayerPos();

        var floorNum = parseInt(pub.player.floor);
        if (this.playerTile.x == this.endTile.x && this.playerTile.y == this.endTile.y) {
            floorNum = floorNum + 1;
            pub.player.lastFloor = pub.player.floor;
            pub.player.floor = floorNum;
            pub.save();
            cc.director.loadScene("floor" + floorNum);
        }
        if (this.playerTile.x == this.startTile.x && this.playerTile.y == this.startTile.y) {
            floorNum = floorNum - 1;
            pub.player.lastFloor = pub.player.floor;
            if(floorNum >= 0){
                pub.player.floor = floorNum;
                pub.save();
                cc.director.loadScene("floor" + floorNum);
            }
        }
    },


    killEnemy:function(newTile){
        var enemys = this.enemyObject;
        var that = this;
        // cc.log('player x = ' + newTile.x + ", player y = " + newTile.y);
        for(var i = 0; i < enemys.length; i++){
            if(newTile.x == enemys[i].tiledX && newTile.y == enemys[i].tiledY){
                var hits = enemyData.canKill(enemys[i].enemytype, pub.player);
                if(hits == 0){
                    cc.log(' cant battle ');
                    return false;
                }
                battle.show(pub.player, enemyData.getEnemy(enemys[i].enemytype), hits, function(){
                    pub.refreshTitle(that.title);
                });
                enemyData.killEnemy(enemys[i].id, pub.player);
                if(enemys[i].cocosNode){
                    enemys[i].cocosNode.destroy();
                }
                enemys.splice(i,1);
                break;
            }
        }
        return true;
    },

    //加载地图文件时调用
    loadMap: function () {
        this.enemy = this.tiledMap.getObjectGroup('enemy');
        this.enemyObject = [];
        var that = this;
        if(this.enemy){
            var enemys = this.enemy.getObjects();
            //多个图片加载
            cc.loader.loadResDir('texture/enemy', cc.SpriteFrame, function (err, texture, urls) {
                for(var i = 0; i < enemys.length; i++){
                    // cc.log("enemy = " + JSON.stringify(enemys[i]));
                    if(enemyData.existEnemy(enemys[i].id, pub.player)){
                        continue;
                    }

                    var testnode = new cc.Node(enemys[i].id);
                    var testsprite = testnode.addComponent(cc.Sprite);
                    testsprite.spriteFrame = cc.loader.getRes("texture/enemy/enemy"+enemys[i].enemytype, cc.SpriteFrame);
                    testnode.setPosition(enemys[i].x,enemys[i].y);
                    that.node.addChild(testnode);

                    var tmp = that.getTilePos(enemys[i]);
                    enemys[i].tiledX = tmp.x;
                    enemys[i].tiledY = tmp.y;
                    enemys[i].cocosNode = testnode;
                    that.enemyObject.push(enemys[i]);
                }
            });
        }

        //计数器
        pub.refreshTitle(this.title);
        itemData.initItem(this.tiledMap, pub.player);
        //障碍物图层和星星图层
        // this.ground = this.tiledMap.getLayer('ground');
        this.wall = this.tiledMap.getLayer('wall');
        //出生Tile和结束Tile
        //startPoint和endPoint对象
        var updown = this.tiledMap.getObjectGroup('updown');
        var startPoint = updown.getObject('down');
        var endPoint = updown.getObject('up');
        this.startTile = this.getTilePos(startPoint);
        this.endTile = this.getTilePos(endPoint);

        if(pub.player.lastFloor < pub.player.floor){
            this.playerTile = this.startTile;
        }else{
            this.playerTile = this.endTile;
        }

        //更新player位置
        this.updatePlayerPos();

    },

    //将像素坐标转化为瓦片坐标
    getTilePos: function(posInPixel) {
        var mapSize = this.node.getContentSize();
        var tileSize = this.tiledMap.getTileSize();
        var x = Math.floor(posInPixel.x / tileSize.width);
        var y = Math.floor((mapSize.height - posInPixel.y) / tileSize.height);
        return cc.v2(x, y);
    },

    updatePlayerPos: function() {
        var pos = this.wall.getPositionAt(this.playerTile);
        this.player.setPosition(pos);
    },
    // update (dt) {},
});
