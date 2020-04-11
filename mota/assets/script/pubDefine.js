module.exports = {
    player:{
        x:0,
        y:0,
        floor: 0,
        lastFloor:-1,
        hp:1000,
        level:1,
        atk:15,
        def:10,
        exp: 100,
        money: 100,
        yellowKey:0,
        blueKey:0,
        redKey:0,
        buyTimes:{},    //记录各种商店的购买次数 shop_type:times
        disappearItems:{},
        disappearEnemys:{}
    },
    shop:{
        shop1:{
            type:1,
            name:'金币',
            init:20,
            increment:1,
            hp:500,
            atk:3,
            def:3
        },
        shop2:{
            type:2,
            name:'经验',
            init:20,
            increment:1,
            hp:500,
            atk:3,
            def:3
        }
    },
    initGame:function(){
        this.player.x = 0;
        this.player.y = 0;
        this.player.floor = 0;
        this.player.lastFloor = -1;
        this.player.hp = 1000;
        this.player.level = 1;
        this.player.atk = 10;
        this.player.def = 10;
        this.player.exp = 0;
        this.player.money = 0;
        this.player.yellowKey = 0;
        this.player.blueKey = 0;
        this.player.redKey = 0;
        this.player.buyTimes = {};
        this.player.disappearItems = {};
        this.player.disappearEnemys = {};

        cc.sys.localStorage.removeItem("autodata");
        for(var i = 0; i < 3; i++){
            cc.sys.localStorage.removeItem("userdata_" + i);
        }
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
            return true;
        }

        return false;
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
