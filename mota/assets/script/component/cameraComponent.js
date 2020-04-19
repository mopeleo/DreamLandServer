// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        camera: cc.Camera,
        node_shows: [cc.Sprite],
        icon: cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        var texture = new cc.RenderTexture();
        texture.initWithSize(this.node_shows[0].node.width, this.node_shows[0].node.height);
        var spriteFrame = new cc.SpriteFrame();
        spriteFrame.setTexture(texture);
        this.camera.targetTexture = texture;
        this.node_shows.forEach((v) => {
            v.spriteFrame = spriteFrame;
        });

        this.node.on(cc.Node.EventType.TOUCH_MOVE, (event)=>{
            this.icon.x += event.getDeltaX();
            this.icon.y += event.getDeltaY();
            this.node_shows.forEach((v, i) => {
                const dis = this.node.position.sub(v.node.position).mag();
                if (dis > 0) {
                    v.node.stopAllActions();
                    v.node.runAction(cc.moveTo(i * 0.05 + 0.02, this.icon.x, this.icon.y));
                }
            })
        }, this);

        // this.schedule(this.shadowFollow, 0.1, cc.macro.REPEAT_FOREVER);

    },


    shadowFollow() {
        this.node_shows.forEach((v, i) => {
            const dis = this.node.position.sub(v.node.position).mag();
            if (dis > 0) {
                v.node.stopAllActions();
                v.node.runAction(cc.moveTo(i * 0.05 + 0.02, this.icon.x, this.icon.y));
            }
        })
    },

    start () {

    },

    // update (dt) {},
});
