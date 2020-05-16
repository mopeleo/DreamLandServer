// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

var PlayerData = require("playerData");

cc.Class({
    extends: cc.Component,

    properties: {
        // foo: {
        //     // ATTRIBUTES:
        //     default: null,        // The default value will be used only when the component attaching
        //                           // to a node for the first time
        //     type: cc.SpriteFrame, // optional, default is typeof default
        //     serializable: true,   // optional, default is true
        // },
        // bar: {
        //     get () {
        //         return this._bar;
        //     },
        //     set (value) {
        //         this._bar = value;
        //     }
        // },
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        PlayerData.load();
    },

    normalGame(event, customData){
        PlayerData.param.sceneType = parseInt(customData);
        cc.director.preloadScene("gameinfo", function () {
            cc.director.loadScene("gameinfo");
        });
    },

    challengeGame(){
        PlayerData.param.sceneType = 0;
        if(!PlayerData.player.scene.challenge.level){
            PlayerData.player.scene.challenge.level = PlayerData.param.challengeBegin;
        }
        PlayerData.param.sceneIndex = PlayerData.player.scene.challenge.level;
        cc.director.preloadScene("chessboard", function () {
            cc.director.loadScene("chessboard");
        });
    },

    rankPage(){
        cc.director.loadScene("gameinfo");
    },

    // update (dt) {},
});
