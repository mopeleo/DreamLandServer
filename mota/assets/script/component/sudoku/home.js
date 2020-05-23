var PlayerData = require("playerData");

cc.Class({
    extends: cc.Component,

    properties: {
    },

    onLoad () {
        PlayerData.load();
        // // 设置游戏窗口变化的回调
        // cc.view.setResizeCallback(() => this.adapt());
        // // 程序运行时主动调用一次
        // this.adapt();
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

    adapt() {
        // 实际屏幕比例
        let screenRatio = cc.winSize.width / cc.winSize.height;
        // 设计比例
        let designRatio = cc.Canvas.instance.designResolution.width / cc.Canvas.instance.designResolution.height;
        // 判断实际屏幕宽高比
        if (screenRatio <= 1) {
            // 此时屏幕高度大于宽度
            if (screenRatio <= designRatio) {
                this.setFitWidth();
            } else {
                // 此时实际屏幕比例大于设计比例
                // 为了保证纵向的游戏内容不受影响，应使用 fitHeight 模式
                this.setFitHeight();
            }
        } else {
            // 此时屏幕高度小于宽度
            this.setFitHeight();
        }
    },

    /**
     * 适配高度模式
     */
    setFitHeight() {
        cc.Canvas.instance.fitHeight = true;
        cc.Canvas.instance.fitWidth = false;
    },

    /**
     * 适配宽度模式
     */
    setFitWidth() {
        cc.Canvas.instance.fitHeight = false;
        cc.Canvas.instance.fitWidth = true;
    },
    // update (dt) {},
});
