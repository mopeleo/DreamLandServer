module.exports = {
    player:{
        isBattle:false,
        floor: 0,
        lastFloor:-1,
        hp:1000,
        level:1,
        atk:10,
        def:10,
        exp: 0,
        money: 0,
        yellowKey:0,
        blueKey:0,
        redKey:0,
        disappearItems:{},
        disappearEnemys:{}
    },
    save:function(type){
        if(type){
            cc.sys.localStorage.setItem("userdata_" + type, JSON.stringify(this.player));
        }else{
            cc.sys.localStorage.setItem("autodata", JSON.stringify(this.player));
        }
    },
    load:function(type){
        var datastring = null;
        if(type){
            datastring = cc.sys.localStorage.getItem("userdata_" + type);
        }else{
            datastring = cc.sys.localStorage.getItem("autodata");
        }
        if(datastring && datastring != null){
            this.player = JSON.parse(datastring);
        }
    },
    clear:function(){
        cc.sys.localStorage.removeItem("autodata");
        cc.sys.localStorage.removeItem("userdata");
    },
    refreshTitle:function(titleComponent){
        titleComponent.getChildByName("item10Value").getComponent(cc.Label).string = this.player.yellowKey;
        titleComponent.getChildByName("item11Value").getComponent(cc.Label).string = this.player.blueKey;
        titleComponent.getChildByName("item12Value").getComponent(cc.Label).string = this.player.redKey;
        titleComponent.getChildByName("levelValue").getComponent(cc.Label).string = this.player.level;
        titleComponent.getChildByName("hpValue").getComponent(cc.Label).string = this.player.hp;
        titleComponent.getChildByName("atkValue").getComponent(cc.Label).string = this.player.atk;
        titleComponent.getChildByName("defValue").getComponent(cc.Label).string = this.player.def;
        titleComponent.getChildByName("moneyValue").getComponent(cc.Label).string = this.player.money;
        titleComponent.getChildByName("expValue").getComponent(cc.Label).string = this.player.exp;
        titleComponent.getChildByName("floorValue").getComponent(cc.Label).string = this.player.floor;
    },
};
