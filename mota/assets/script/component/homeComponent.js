let sceneList = {
  'scroll' : '背景无限滚动',
  'joystick' : '遥控杆',
  'index' : '魔塔',
  'scratch' : '刮刮卡实现',
  'coinfly' : '金币落袋效果',
  'glass' : '局部缩放效果',
  'Change_clothes' : '换装',
  'typer' : '打字机效果',
  'render' : '移动残影效果',
  'blood' : '血条',
  // 'follow' : '光影跟随',
  'bullet' : '跟踪子弹'
};
const LOAD_SCENE_MIN_SEC = 1.2;


cc.Class({
    extends: cc.Component,

    properties: {
        loadingNode: cc.Node,
        loadingProgress: cc.ProgressBar,
        scrollContent: cc.Node,

        beginLoad: false,
        finishLoadFlag: false,
        loadTime:0,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        for (let key in sceneList) {
            var scrollItem = new cc.Node();
            var label = scrollItem.addComponent(cc.Label);
            label.fontSize = 20;
            label.string = sceneList[key];

            scrollItem.on(cc.Node.EventType.TOUCH_END,
                () => {
                    cc.tween(scrollItem)
                        .to(0.1, {scale: 1.05})
                        .to(0.1, {scale: 1})
                        .start();
                    this.loadScene(key);
                },
                this
            );

            this.scrollContent.addChild(scrollItem);
        }

    },

    loadScene(key) {
        if (this.beginLoad) return;
        this.loadingProgress.progress = 0;
        this.loadingNode.active = true;
        this.beginLoad = true;
        this.loadSceneName = key;

        cc.director.preloadScene(
            key,
            (completedCount, totalCount) => {
                // 还是做假进度条吧，缓存之后太快了，一闪而过的体验不好
                // this.loadingProgress.progress = completedCount / totalCount;
                // this.loadingProgress.node.getChildByName("per").getComponent(cc.Label).string = Math.round(this.loadingProgress.progress*100)+"%";
            },
            (error, asset) => {
                // 假进度条
                if (!error) {
                    this.finishLoadFlag = true;
                } else {
                    this.loadingNode.active = false;
                    this.beginLoad = false;
                    this.loadTime = 0;
                }

                //正常进度条
                // cc.director.getScene().getChildByName('btn_back_home').active = true;
                // cc.director.loadScene(this.loadSceneName);

            }
        );
    },

    //假进度条
    update (dt) {
        if (!this.beginLoad) return;

        if (this.loadTime >= LOAD_SCENE_MIN_SEC && this.finishLoadFlag) {
            this.loadingProgress.progress = 1;
            cc.director.getScene().getChildByName('btn_back_home').active = true;
            cc.director.loadScene(this.loadSceneName);
        } else {
            this.loadTime += dt;
            this.loadingProgress.progress = Math.min(this.loadTime / LOAD_SCENE_MIN_SEC, this.finishLoadFlag ? 1 : 0.9);
            this.loadingProgress.node.getChildByName("per").getComponent(cc.Label).string = Math.round(this.loadingProgress.progress*100)+"%";
        }
    },
});
