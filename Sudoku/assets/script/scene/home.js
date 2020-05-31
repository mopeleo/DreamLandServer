var PlayerData = require("../common/playerData");

cc.Class({
    extends: cc.Component,

    properties: {
        avatar: cc.Sprite,
        nameLab: cc.Label,
        goldLab: cc.Label,
        userNode: cc.Node,
        rankingNode: cc.Node,
    },

    onLoad () {
        PlayerData.load();
        if(PlayerData.player.userName == '' || PlayerData.player.avatarUrl == ''){
            this.wxOnClickAuth();
        }else{
            this.initUserInfo();
        }

        this.rankingNode.on(cc.Node.EventType.TOUCH_START,function(event){
            event.stopPropagation();
        });
        this.rankingNode.on(cc.Node.EventType.TOUCH_END, function (event) {
            event.stopPropagation();
        });
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
        this.setScore(100);
        // this.getRank();
        this.rankingNode.active = true;
    },

    backHome(){
        this.rankingNode.active = false;
    },

    getRank() {
        let wx = window['wx'];
        if (typeof wx === 'undefined') {
            return;
        }
        wx.postMessage({
            event: 'getRank'
        });
    },

    setScore(value) {
        let wx = window['wx'];
        if (typeof wx === 'undefined') {
            return;
        }
        console.log("set score");
        let score = Math.round(Math.random() * 100);
        wx.getOpenDataContext().postMessage({
            message: score
        });
        // wx.postMessage({
        //     event: 'setScore',
        //     score: value
        // });
    },

    wxOnClickAuth(){
        let self = this;
        let wx = window['wx'];
        if (typeof wx === 'undefined') {
            return;
        }
        let sysInfo = wx.getSystemInfoSync();
        //获取微信界面大小
        let width = sysInfo.screenWidth;
        let height = sysInfo.screenHeight;
        wx.getSetting({
            success (res) {
                console.log(res.authSetting);
                if (res.authSetting["scope.userInfo"]) {
                    console.log("用户已授权");
                    wx.getUserInfo({
                        success(res){
                            self.initUserInfo(res.userInfo);
                        }
                    });
                }else{
                    console.log("用户未授权");
                    let button = wx.createUserInfoButton({
                        type: 'text',
                        text: '',
                        style: {
                            left: 0,
                            top: 0,
                            width: width,
                            height: height,
                            backgroundColor: '#00000000',//最后两位为透明度
                            color: '#ffffff',
                            fontSize: 20,
                            textAlign: "center",
                            lineHeight: height,
                        }
                    });
                    button.onTap((res) => {
                        if (res.userInfo) {
                            console.log("用户授权:", res.userInfo);
                            PlayerData.player.userName = res.userInfo.nickName;
                            PlayerData.player.avatarUrl = res.userInfo.avatarUrl + "?aaa=aa.jpg";
                            PlayerData.save();
                            self.initUserInfo(res.userInfo);
                            //此时可进行登录操作
                            button.destroy();
                        }else {
                            console.log("用户拒绝授权:");
                        }
                    });
                }
            }
        });
    },
    
    initUserInfo(userInfo){
        //用户头像设置
        let self = this;
        var imgurl = PlayerData.player.avatarUrl;
        cc.loader.load(imgurl, function(err, texture){
            self.avatar.spriteFrame = new cc.SpriteFrame(texture);
            self.nameLab.string = PlayerData.player.userName;
            self.goldLab.string = PlayerData.player.gold;
            self.userNode.active = true;
        });
    }
});
