// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        mirror: cc.Node,
        mirrorCameraNode: cc.Node,
        tempCameraSpriteNode: cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad() {
        this.viewSize = cc.view.getVisibleSize();
        this.touchStartPos = null;
        this.mirrorOriginPos = this.mirror.getPosition();
        this.initCamera();
        this.mirrorCameraNode.setPosition(this.mirror.getPosition());

        this.node.on(cc.Node.EventType.TOUCH_START, this.touchStartEvent, this);
        this.node.on(cc.Node.EventType.TOUCH_MOVE, this.touchMoveEvent, this);

        // 设置游戏窗口变化的回调
        cc.view.setResizeCallback(() => this.adapt());
        // 程序运行时主动调用一次
        this.adapt();

    },

    touchStartEvent(event) {
      this.touchStartPos = event.getLocation();
      this.mirrorOriginPos = this.mirror.getPosition();
    },

    touchMoveEvent(event) {
      let touchPos = event.getLocation();
      let pos = this.mirrorOriginPos.add(touchPos.subtract(this.touchStartPos));

      this.mirror.setPosition(pos);
      this.mirrorCameraNode.setPosition(pos);
    },

    initCamera() {
        let visibleRect = cc.view.getVisibleSize();

        let texture = new cc.RenderTexture();
        texture.initWithSize(visibleRect.width, visibleRect.height);
        let spriteFrame = new cc.SpriteFrame();
        spriteFrame.setTexture(texture);
        this.mirrorCameraNode.getComponent(cc.Camera).targetTexture = texture;

        this.tempCameraSpriteNode.getComponent(cc.Sprite).spriteFrame = spriteFrame;
        this.tempCameraSpriteNode.scaleY = -1;
    },
    // update (dt) {},


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

});
