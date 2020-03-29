var battle = {
    _battle: null,           // prefab
    _animSpeed:     0.3,    // 动画速度
};


battle.show = function (playerData, enemyData, callBack) {
    var hits = 0;
    var playerHit = Math.ceil(enemyData.hp/(playerData.atk-enemyData.def));
    var enemyHit = (enemyData.atk == playerData.def ? -1 : Math.ceil(playerData.hp/(enemyData.atk-playerData.def)));
    // cc.log("playerHit :" + playerHit + " ,enemyHit: " + enemyHit);
    if(enemyHit < 0 || enemyHit > playerHit){
        hits = playerHit - 1;
    }else{
        return;
    }

    playerData.isBattle = true;

    // 引用
    var self = this;

    // 加载 prefab 创建
    cc.loader.loadRes("prefab/battle", cc.Prefab, function (error, prefab) {

        if (error) {
            cc.error(error);
            return;
        }

        // 实例
        var battlePrefab = cc.instantiate(prefab);
        var enemyIcon = battlePrefab.getChildByName("enemy").getComponent(cc.Sprite);
        enemyIcon.spriteFrame = cc.loader.getRes("texture/enemy/enemy"+enemyData.type, cc.SpriteFrame);

        // battle 持有
        battle._battle = battlePrefab;

        // 动画
        var cbFadeOut = cc.callFunc(self.onFadeOutFinish, self);
        var cbFadeIn = cc.callFunc(self.onFadeInFinish, self);
        self.actionFadeIn = cc.sequence(cc.spawn(cc.fadeTo(battle._animSpeed, 255), cc.scaleTo(battle._animSpeed, 1.0)), cbFadeIn);
        self.actionFadeOut = cc.sequence(cc.spawn(cc.fadeTo(battle._animSpeed, 0), cc.scaleTo(battle._animSpeed, 2.0)), cbFadeOut);

        // 父视图
        battle._battle.parent = cc.find("Canvas");

        // 展现 battle
        self.startFadeIn();
        var playerHpLab = battlePrefab.getChildByName("phpValue").getComponent(cc.Label);
        playerHpLab.string = playerData.hp;
        var playerHp = playerData.hp;

        var playerAtkLab = battlePrefab.getChildByName("patkValue").getComponent(cc.Label);
        playerAtkLab.string = playerData.atk;
        var playerAtk = playerData.atk;

        var playerDefLab = battlePrefab.getChildByName("pdefValue").getComponent(cc.Label);
        playerDefLab.string = playerData.def;
        var playerDef = playerData.def;

        var enemyHpLab = battlePrefab.getChildByName("ehpValue").getComponent(cc.Label);
        enemyHpLab.string = enemyData.hp;
        var enemyHp = enemyData.hp;

        var enemyAtkLab = battlePrefab.getChildByName("eatkValue").getComponent(cc.Label);
        enemyAtkLab.string = enemyData.atk;
        var enemyAtk = enemyData.atk;

        var enemyDefLab = battlePrefab.getChildByName("edefValue").getComponent(cc.Label);
        enemyDefLab.string = enemyData.def;
        var enemyDef = enemyData.def;

        playerAtkLab.schedule(function() {
            // 这里的 this 指向 component
            if(enemyAtk-playerDef > 0){
                playerHp = playerHp - (enemyAtk-playerDef);
                playerHpLab.string = playerHp;
            }
            enemyHp = enemyHp - (playerAtk-enemyDef);
            enemyHpLab.string = enemyHp;
            if(enemyHp <= 0){
                playerData.hp = playerHp;
                playerData.isBattle = false;
                if(callBack){
                    callBack();
                }
                self.onDestory();
            }
         }, 0.5, hits);

    });

    // 执行弹进动画
    self.startFadeIn = function () {
        // cc.eventManager.pauseTarget(battle._battle, true);
        battle._battle.pauseSystemEvents(true);
        battle._battle.setPosition(0,0);
        battle._battle.setScale(2);
        battle._battle.opacity = 0;
        battle._battle.runAction(self.actionFadeIn);
    };

    // 执行弹出动画
    self.startFadeOut = function () {
        // cc.eventManager.pauseTarget(battle._battle, true);
        battle._battle.pauseSystemEvents(true);
        battle._battle.runAction(self.actionFadeOut);
    };

    // 弹进动画完成回调
    self.onFadeInFinish = function () {
        // cc.eventManager.resumeTarget(battle._battle, true);
        battle._battle.resumeSystemEvents(true);
    };

    // 弹出动画完成回调
    self.onFadeOutFinish = function () {
        self.onDestory();
    };

    // 销毁 battle (内存管理还没搞懂，暂且这样写吧~v~)
    self.onDestory = function () {
        battle._battle.destroy();
        battle._battle = null;
        battle._animSpeed = 0.3;
    };
};
