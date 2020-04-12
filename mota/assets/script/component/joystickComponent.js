// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        controlDot: cc.Node,
        joystick: cc.Node,
        star: cc.Node,
        movableFlag: false,
        radian: 0,
        speed: 150,
    },

    initTouchEvent() {
        this.node.on(cc.Node.EventType.TOUCH_START, this.touchStartEvent, this);
        this.node.on(cc.Node.EventType.TOUCH_MOVE, this.touchMoveEvent, this);
        this.node.on(cc.Node.EventType.TOUCH_END, this.touchEndEvent, this);
        this.node.on(cc.Node.EventType.TOUCH_CANCEL, this.touchEndEvent, this);
    },

    touchStartEvent(event) {
        let touchPos = this.node.convertToNodeSpaceAR(event.getLocation());
        const distance = touchPos.len();
        const radius = this.node.width / 2 - this.controlDot.width / 2;

        // 以x轴正方向为基准，计算偏移量
        this.radian = cc.v2(1, 0).signAngle(touchPos);
        const offsetX = Math.cos(this.radian) * radius;
        const offsetY = Math.sin(this.radian) * radius;
        this.controlDot.setPosition(radius > distance ? touchPos : cc.v2(offsetX, offsetY));

        this.movableFlag = true;
    },

    touchMoveEvent(event) {
        let touchPos = this.node.convertToNodeSpaceAR(event.getLocation());
        const distance = touchPos.len();
        const radius = this.node.width / 2 - this.controlDot.width / 2;

        this.radian = cc.v2(1, 0).signAngle(touchPos);
        const offsetX = Math.cos(this.radian) * radius;
        const offsetY = Math.sin(this.radian) * radius;

        this.controlDot.setPosition(radius > distance ? touchPos : cc.v2(offsetX, offsetY));
    },

    touchEndEvent() {
        this.movableFlag = false;
        this.controlDot.setPosition(cc.v2(0, 0));
    },

    start() {
        this.initTouchEvent();
    },

    update (dt) {
        if (!this.movableFlag) return;
        var movex = Math.cos(this.radian) * dt * this.speed;
        var movey = Math.sin(this.radian) * dt * this.speed;

        var viewSize = cc.view.getVisibleSize();
        var boldx = (viewSize.width - this.star.width)/2;
        var boldy = (viewSize.height - this.star.height)/2;

        if(this.star.x + movex > boldx){
            this.star.x = boldx;
        }else if(this.star.x + movex < -boldx){
            this.star.x = -boldx;
        }else{
            this.star.x += movex;
        }
        if(this.star.y + movey > boldy){
            this.star.y = boldy;
        }else if(this.star.y + movey < -boldy){
            this.star.y = -boldy;
        }else{
            this.star.y += movey;
        }

    },
});
