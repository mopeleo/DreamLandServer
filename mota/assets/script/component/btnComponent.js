var pub = require("../pubDefine");

cc.Class({
    extends: cc.Component,

    properties: {
    },

    // LIFE-CYCLE CALLBACKS:

    // onLoad () {},

    start () {

    },

    newGame:function(){
        pub.initGame();
        cc.director.loadScene("floor0");
    },

    exitApp:function(){
        cc.game.end();
    },

    autoSave:function(){
        pub.save();
    },

    customSave:function(){
        pub.save("1");
    },

    autoLoad:function(){
        var flag = pub.load();
        if(flag){
            var sceneName = "floor" + pub.player.floor;
            cc.director.loadScene(sceneName);
        }
    },

    customLoad:function(){
        var flag = pub.load("1");
        if(flag){
            var sceneName = "floor" + pub.player.floor;
            cc.director.loadScene(sceneName);
        }
    },

    // update (dt) {},
});
