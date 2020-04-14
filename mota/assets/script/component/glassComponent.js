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
    }
    // update (dt) {},
});
