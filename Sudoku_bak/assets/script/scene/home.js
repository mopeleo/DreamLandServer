let GameLib = require("../common/gameLib");
let PlayerData = require("../common/playerData");
let wx = window['wx'];

cc.Class({
    extends: cc.Component,

    properties: {
        avatar: cc.Sprite,
        fighter: cc.Sprite,
        nameLab: cc.Label,
        goldLab: cc.Label,
        userNode: cc.Node,
        rankingNode: cc.Node,
        actorNode: cc.Node,
        achievementNode: cc.Node,
        achieveContentNode: cc.Node,
        achievePrefab: cc.Prefab,
    },

    onLoad () {
        PlayerData.load();
        if (typeof wx !== 'undefined') {
            this.wxOnClickAuth();
            // this.initUserInfo();
        }

        this.updateFighter(PlayerData.player.actor);

        this.rankingNode.on(cc.Node.EventType.TOUCH_START, function(event){
            event.stopPropagation();
        });
        this.rankingNode.on(cc.Node.EventType.TOUCH_END, function (event){
            event.stopPropagation();
        });

        this.initActorPage();
        this.initAchievementPage();
    },

    normalGame(event, customData){
        PlayerData.param.sceneType = parseInt(customData);
        PlayerData.param.sceneIndex = PlayerData.getPlayerCurrentIndex(PlayerData.param.sceneType);
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
        if (typeof wx === 'undefined') {
            return;
        }
        //每次查询前先把最新成绩送上
        wx.getOpenDataContext().postMessage({
            message: PlayerData.player.star
        });
        this.rankingNode.active = true;
    },

    rankBackHome(){
        if (typeof wx === 'undefined') {
            return;
        }
        //如果不删除，下次打开排行榜时会有重复内容出现
        wx.getOpenDataContext().postMessage({
            message: 'clear'
        });
        this.rankingNode.active = false;
    },

    initActorPage(){
        this.actorNode.on(cc.Node.EventType.TOUCH_START, function(event){
            event.stopPropagation();
        });
        this.actorNode.on(cc.Node.EventType.TOUCH_END, function (event){
            event.stopPropagation();
        });

        var contentNode = this.actorNode.getChildByName("content");
        contentNode.getChildByName("unlockBtn").on(cc.Node.EventType.TOUCH_END, ()=>{
            var actorKey = "actor_" + this.actorCurrentPage;
            if(PlayerData.player.haveActors.indexOf(actorKey) != -1){
                return;
            }
            PlayerData.player.haveActors.push(actorKey);
            // PlayerData.save();
            contentNode.getChildByName("unlockBtn").getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));
            contentNode.getChildByName("actorPic").getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-sprite'));
            cc.tween(contentNode.getChildByName("actorPic")).by(0.1, {position: cc.v2(15,15)}).by(0.1, {position: cc.v2(-15,-15)}).start();
        });

        contentNode.getChildByName("fightBtn").on(cc.Node.EventType.TOUCH_END, ()=>{
            var actorKey = "actor_" + this.actorCurrentPage;
            if(PlayerData.player.actor == actorKey){
                return;
            }
            this.updateFighter(actorKey);
            contentNode.getChildByName("fightBtn").getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));
            cc.tween(contentNode.getChildByName("actorPic")).by(0.1, {position: cc.v2(15,15)}).by(0.1, {position: cc.v2(-15,-15)}).start();
        });

        this.actorNode.getChildByName("preBtn").on(cc.Node.EventType.TOUCH_END, ()=>{
            if(this.actorCurrentPage <= 1){
                return;
            }
            this.actorCurrentPage--;
            this.updateActorPage(this.actorCurrentPage);
        });
        this.actorNode.getChildByName("nextBtn").on(cc.Node.EventType.TOUCH_END, ()=>{
            if(this.actorCurrentPage >= Object.keys(GameLib.actor).length){
                return;
            }
            this.actorCurrentPage++;
            this.updateActorPage(this.actorCurrentPage);
        });
    },

    updateActorPage(index){
        this.actorNode.getChildByName("pageLab").getComponent(cc.Label).string = index + "/" + Object.keys(GameLib.actor).length;

        var actorKey = "actor_" + index;
        var currentActor = GameLib.actor[actorKey];
        var contentNode = this.actorNode.getChildByName("content");
        // cc.loader.loadResDir('texture', cc.SpriteFrame, function(err, texture, urls){    //只用加载一次，前面updateFighter已加载过
            var actorSprite = contentNode.getChildByName("actorPic").getComponent(cc.Sprite);
            actorSprite.spriteFrame = cc.loader.getRes(GameLib.actorDir + actorKey, cc.SpriteFrame);
            if(PlayerData.player.haveActors.indexOf(actorKey) == -1){
                actorSprite.setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));    //变灰
                contentNode.getChildByName("unlockBtn").getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-sprite'));
            }else{
                actorSprite.setMaterial(0, cc.Material.getBuiltinMaterial('2d-sprite'));
                contentNode.getChildByName("unlockBtn").getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));
            }
            if(PlayerData.player.actor === actorKey){
                contentNode.getChildByName("fightBtn").getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));
            }else{
                contentNode.getChildByName("fightBtn").getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-sprite'));
            }

            contentNode.getChildByName("actorName").getComponent(cc.Label).string = currentActor.name;
            contentNode.getChildByName("actorLife").getComponent(cc.Label).string = currentActor.life;
            var actorSkill = GameLib.getActorSkill(actorKey);
            contentNode.getChildByName("actorSkill").getComponent(cc.Label).string = actorSkill.desc;
            contentNode.getChildByName("unlock").getComponent(cc.Label).string = currentActor.unlockRemark;

        // });
    },

    actorPage(){
        this.actorCurrentPage = PlayerData.player.actor.split("_")[1];
        this.updateActorPage(this.actorCurrentPage);
        // this.scheduleOnce(()=>{this.actorNode.active = true;}, 0.2);
        this.actorNode.active = true;
    },

    actorBackHome(){
        this.actorNode.active = false;
    },

    shopPage(){
        cc.director.preloadScene("gameitempage", function () {
            cc.director.loadScene("gameitempage");
        });
    },

    initAchievementPage(){
        this.achievementNode.on(cc.Node.EventType.TOUCH_START, function(event){
            event.stopPropagation();
        });
        this.achievementNode.on(cc.Node.EventType.TOUCH_END, function (event){
            event.stopPropagation();
        });

        this.achieveArray = [];
        var achieveLen = Object.keys(GameLib.achieve).length;
        for(var i = 0; i < achieveLen; i++){
            var achieveKey = "achieve_" + (i + 1);
            var achieveNode = cc.instantiate(this.achievePrefab);
            if(PlayerData.player.haveAchieves.indexOf(achieveKey) != -1){
                achieveNode.getChildByName("desc").getComponent(cc.Label).string = GameLib.achieve[achieveKey].name;
            }
            this.achieveArray.push(achieveNode);
            this.achieveContentNode.addChild(achieveNode);
        }
    },

    achievementPage(){
        for(var i = 0; i < this.achieveArray.length; i++){
            var achieveKey = "achieve_" + (i + 1);
            if(PlayerData.player.haveAchieves.indexOf(achieveKey) != -1){
                this.achieveArray[i].getChildByName("desc").getComponent(cc.Label).string = GameLib.achieve[achieveKey].name;
            }
        }
        this.achievementNode.active = true;
    },

    achievementBackHome(){
        this.achievementNode.active = false;
    },

    wxOnClickAuth(){
        let self = this;
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
                            console.log("用户拒绝授权");
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
    },

    updateFighter(actorKey){
        PlayerData.player.actor = actorKey;
        cc.loader.loadResDir(GameLib.actorDir, cc.SpriteFrame, (err, texture, urls)=>{
            this.fighter.spriteFrame = cc.loader.getRes(GameLib.actorDir + actorKey, cc.SpriteFrame);
        });
    },
});
