var PlayerData = require("playerData");

cc.Class({
    extends: cc.Component,

    properties: {
    },

    onLoad () {
        PlayerData.load();
    },

    normalGame(event, customData){
        PlayerData.param.sceneType = parseInt(customData);
        cc.director.preloadScene("gameinfopage", function () {
            cc.director.loadScene("gameinfopage");
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
        cc.director.preloadScene("gameinfoscroll", function () {
            cc.director.loadScene("gameinfoscroll");
        });
    },

});
