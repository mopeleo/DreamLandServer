// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        sheep: cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        // 开启物理系统
        cc.director.getPhysicsManager().enabled = true;
        this.gang_body = this.sheep.getComponent(cc.RigidBody);
    },

    jump(){
        // 给主角y轴正方形350的速度，然后受重力下落
        var speed_xy = this.gang_body.linearVelocity;
        speed_xy.x = 100;
        speed_xy.y = 350;
        this.gang_body.linearVelocity = speed_xy;
    },


    // update (dt) {},
});
