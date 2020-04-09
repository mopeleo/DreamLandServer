var battle = {
    _battle: null,      // prefab
    _animSpeed: 0.3,    // 动画速度
};


battle.show = function (playerData, enemyData, hits, callBack) {
    if(hits <= 0){
        return;
    }

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
        // battle 持有
        battle._battle = battlePrefab;
        // 父视图
        battle._battle.parent = cc.find("Canvas");

        var mask = battlePrefab.getChildByName("mask");
        mask.on('touchstart',function(event){
            event.stopPropagation();
        });

        mask.on('touchend', function (event) {
            event.stopPropagation();
        });
        var enemyIcon = mask.getChildByName("enemy").getComponent(cc.Sprite);
        enemyIcon.spriteFrame = cc.loader.getRes("texture/enemy/enemy"+enemyData.type, cc.SpriteFrame);


        // 动画
        var cbFadeOut = cc.callFunc(self.onFadeOutFinish, self);
        var cbFadeIn = cc.callFunc(self.onFadeInFinish, self);
        self.actionFadeIn = cc.sequence(cc.spawn(cc.fadeTo(battle._animSpeed, 255), cc.scaleTo(battle._animSpeed, 1.0)), cbFadeIn);
        self.actionFadeOut = cc.sequence(cc.spawn(cc.fadeTo(battle._animSpeed, 0), cc.scaleTo(battle._animSpeed, 2.0)), cbFadeOut);


        // 展现 battle
        self.startFadeIn();
        var playerHpLab = mask.getChildByName("phpValue").getComponent(cc.Label);
        playerHpLab.string = playerData.hp;
        var playerHp = playerData.hp;

        var playerAtkLab = mask.getChildByName("patkValue").getComponent(cc.Label);
        playerAtkLab.string = playerData.atk;
        var playerAtk = playerData.atk;

        var playerDefLab = mask.getChildByName("pdefValue").getComponent(cc.Label);
        playerDefLab.string = playerData.def;
        var playerDef = playerData.def;

        var enemyHpLab = mask.getChildByName("ehpValue").getComponent(cc.Label);
        enemyHpLab.string = enemyData.hp;
        var enemyHp = enemyData.hp;

        var enemyAtkLab = mask.getChildByName("eatkValue").getComponent(cc.Label);
        enemyAtkLab.string = enemyData.atk;
        var enemyAtk = enemyData.atk;

        var enemyDefLab = mask.getChildByName("edefValue").getComponent(cc.Label);
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
                playerData.money += enemyData.money;
                playerData.exp += enemyData.exp;
                if(callBack){
                    callBack();
                }
                self.onDestory();
            }
         }, 0.5, hits-1);  //实际循环次数要 - 1

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

battle.shop = function (playerData, shoptype, callBack) {
    // 引用
    var self = this;

    // 加载 prefab 创建
    cc.loader.loadRes("prefab/shop", cc.Prefab, function (error, prefab) {

        if (error) {
            cc.error(error);
            return;
        }

        // 实例
        var shopPrefab = cc.instantiate(prefab);
        var mask = shopPrefab.getChildByName("mask");
        mask.on('touchstart',function(event){
            event.stopPropagation();
        });

        mask.on('touchend', function (event) {
            event.stopPropagation();
        });

        mask.getChildByName("btnReturn").on('touchend', function (event) {
            self.onDestory();
        });

        // battle 持有
        battle._battle = shopPrefab;

        // 动画
        var cbFadeOut = cc.callFunc(self.onFadeOutFinish, self);
        var cbFadeIn = cc.callFunc(self.onFadeInFinish, self);
        self.actionFadeIn = cc.sequence(cc.spawn(cc.fadeTo(battle._animSpeed, 255), cc.scaleTo(battle._animSpeed, 1.0)), cbFadeIn);
        self.actionFadeOut = cc.sequence(cc.spawn(cc.fadeTo(battle._animSpeed, 0), cc.scaleTo(battle._animSpeed, 2.0)), cbFadeOut);

        // 父视图
        battle._battle.parent = cc.find("Canvas");

        // 展现 battle
        self.startFadeIn();

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

window.battle=battle;
