// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html
const bulletSpeed = 200;

cc.Class({
    extends: cc.Component,

    properties: {
        launch_btn: cc.Node,
        bullet: cc.Node,
        target: cc.Node,
        fireFlag: false,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad() {
        this.target.on(cc.Node.EventType.TOUCH_MOVE, (evt)=>{
            this.target.x += evt.getDeltaX();
            this.target.y += evt.getDeltaY();
        }, this);
    },


    fire() {
        this.bullet.getComponent(cc.Sprite).enabled = true;
        this.bullet.getChildByName('boom').active = false;
        this.bullet.setPosition(this.launch_btn.position);
        this.bullet.active = true;
        this.fireFlag = true;
    },

    hitTheTarget() {
        this.fireFlag = false;
        this.bullet.getComponent(cc.Sprite).enabled = false;
        this.bullet.getChildByName('boom').active = true;
        this.scheduleOnce(() => {
            this.bullet.getChildByName('boom').active = false;
        }, 0.2);
    },

    update(dt) {
        if (!this.fireFlag) return;

        let targetPos = this.target.getPosition();
        let bulletPos = this.bullet.getPosition();
        let normalizeVec = targetPos.subtract(bulletPos).normalize();

        this.bullet.x += normalizeVec.x * bulletSpeed * dt;
        this.bullet.y += normalizeVec.y * bulletSpeed * dt;
        // 角度变化以y轴正方向为起点，逆时针角度递增
        this.bullet.angle = cc.v2(0, 1).signAngle(normalizeVec) * 180 / Math.PI;

        let rect = this.target.getBoundingBox();
        if (rect.contains(bulletPos)) this.hitTheTarget();
    },

    // update (dt) {},
});
