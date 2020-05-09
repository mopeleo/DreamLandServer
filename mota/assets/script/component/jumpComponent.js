// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

const speed = 50;
var jumpCount = 2;
cc.Class({
    extends: cc.Component,

    properties: {
        sheep: cc.Node,
        moveLeft: false,
        moveRight: false,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        // 开启物理系统
        cc.director.getPhysicsManager().enabled = true;
        let manager = cc.director.getCollisionManager();
        manager.enabled = true;     //开启碰撞检测
        manager.enabledDebugDraw = true;   //显示碰撞检测区域

        cc.systemEvent.on(cc.SystemEvent.EventType.KEY_DOWN, this.onKeyDown, this);
        cc.systemEvent.on(cc.SystemEvent.EventType.KEY_UP, this.onKeyUp, this);
        this.gang_body = this.sheep.getComponent(cc.RigidBody);
    },

    jump(){
        if(jumpCount <= 0){
            return;
        }
        // 给主角y轴正方形350的速度，然后受重力下落
        var speed_xy = this.gang_body.linearVelocity;
        // speed_xy.x = 100;
        speed_xy.y = 350;
        this.gang_body.linearVelocity = speed_xy;
        jumpCount--;
    },

    // contact 是碰撞对象,本次碰撞的信息
    // selfCollider: 是自己的碰撞器组件
    // otherCollider: 碰撞到的碰撞器组件;
    // 我们可以有碰撞器组件，来获取我们的碰撞的节点对象
    // 碰撞开始
    onBeginContact: function ( contact, selfCollider, otherCollider) {
        console.log("onBeginContact:", otherCollider.node.name, " ", selfCollider.node.name);
        console.log("onBeginContact:", selfCollider.node.group, otherCollider.node.group);
        console.log("onBeginContact:", selfCollider.node.groupIndex, otherCollider.node.groupIndex);
    },

    // 碰撞结束
    onEndContact: function(contact, selfCollider, otherCollider) {
        console.log("onEndContact");
    },

    // 碰撞持续
    onPreSolve: function(contact, selfCollider, otherCollider) {
        console.log("onPreSolve function");
    },

    // 计算完本次碰撞持续后，调用这个
    onPostSolve: function (contact, selfCollider, otherCollider) {
        console.log("onPostSolve");
    },

    update (dt) {
        if(this.moveLeft){
            this.sheep.x -= dt*speed;
        }else if(this.moveRight){
            this.sheep.x += dt*speed;
        }
    },

    onKeyDown:function(event){
        switch(event.keyCode) {
            // case cc.macro.KEY.up:
            //     newTile.y -= 1;
            //     break;
            // case cc.macro.KEY.down:
            //     newTile.y += 1;
            //     break;
            case cc.macro.KEY.left:
                this.moveLeft = true;
                break;
            case cc.macro.KEY.right:
                this.moveRight = true;
                break;
            default:
                return;
        }
    },

    onKeyUp:function(event){
        switch(event.keyCode) {
            case cc.macro.KEY.left:
                this.moveLeft = false;
                break;
            case cc.macro.KEY.right:
                this.moveRight = false;
                break;
            default:
                return;
        }
    },

    onDestroy () {
        // 取消键盘输入监听
        cc.systemEvent.off(cc.SystemEvent.EventType.KEY_DOWN, this.onKeyDown, this);
        cc.systemEvent.off(cc.SystemEvent.EventType.KEY_UP, this.onKeyUp, this);
    },
});
