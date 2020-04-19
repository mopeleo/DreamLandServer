// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html
const CALC_RECT_WIDTH = 40;
const CLEAR_LINE_WIDTH = 40;

cc.Class({
    extends: cc.Component,

    properties: {
        maskNode: cc.Node,
        ticketNode: cc.Node,
        progerss: cc.Label,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        this.tempDrawPoints = [];
        this.polygonPointsList = [];
        this.reset();
        this.ticketNode.on(cc.Node.EventType.TOUCH_START, this.touchStartEvent, this);
        this.ticketNode.on(cc.Node.EventType.TOUCH_MOVE, this.touchMoveEvent, this);
        this.ticketNode.on(cc.Node.EventType.TOUCH_END, this.touchEndEvent, this);
        this.ticketNode.on(cc.Node.EventType.TOUCH_CANCEL, this.touchEndEvent, this);

    },

    beforeDestroy () {
        this.ticketNode.on(cc.Node.EventType.TOUCH_START, this.touchStartEvent, this);
        this.ticketNode.on(cc.Node.EventType.TOUCH_MOVE, this.touchMoveEvent, this);
        this.ticketNode.on(cc.Node.EventType.TOUCH_END, this.touchEndEvent, this);
        this.ticketNode.on(cc.Node.EventType.TOUCH_CANCEL, this.touchEndEvent, this);

    },

    touchStartEvent(event) {
        let point = this.ticketNode.convertToNodeSpaceAR(event.getLocation());
        this.clearMask(point);
    },

    touchMoveEvent(event) {
        let point = this.ticketNode.convertToNodeSpaceAR(event.getLocation());
        this.clearMask(point);
    },

    touchEndEvent() {
        this.tempDrawPoints = [];
        this.calcProgress();
    },

    calcProgress() {
        let hitItemCount = 0;
        let ctx = this.ticketNode.getComponent(cc.Graphics);
        this.polygonPointsList.forEach((item) => {
            if (!item.isHit) return;
            hitItemCount += 1;

            if (!this.calcDebugger) return;
            ctx.rect(item.rect.x, item.rect.y, item.rect.width, item.rect.height);
            ctx.fillColor = cc.color(216, 18, 18, 255);
            ctx.fill();
        });

        this.progerss.string = `已经刮开了 ${Math.ceil((hitItemCount / this.polygonPointsList.length) * 100)}%`;
    },

    start () {

    },

    // update (dt) {},
    clearMask(pos) {
        let mask = this.maskNode.getComponent(cc.Mask);
        let stencil = mask._graphics;
        const len = this.tempDrawPoints.length;
        this.tempDrawPoints.push(pos);

        if (len <= 1) {
            // 只有一个点，用圆来清除涂层
            stencil.circle(pos.x, pos.y, CLEAR_LINE_WIDTH / 2);
            stencil.fill();

            // 记录点所在的格子
            this.polygonPointsList.forEach((item) => {
                if (item.isHit) return;
                const xFlag = pos.x > item.rect.x && pos.x < item.rect.x + item.rect.width;
                const yFlag = pos.y > item.rect.y && pos.y < item.rect.y + item.rect.height;
                if (xFlag && yFlag) item.isHit = true;
            });
        } else {
            // 存在多个点，用线段来清除涂层
            let prevPos = this.tempDrawPoints[len - 2];
            let curPos = this.tempDrawPoints[len - 1];

            stencil.moveTo(prevPos.x, prevPos.y);
            stencil.lineTo(curPos.x, curPos.y);
            stencil.lineWidth = CLEAR_LINE_WIDTH;
            stencil.lineCap = cc.Graphics.LineCap.ROUND;
            stencil.lineJoin = cc.Graphics.LineJoin.ROUND;
            stencil.strokeColor = cc.color(255, 255, 255, 255);
            stencil.stroke();

            // 记录线段经过的格子
            this.polygonPointsList.forEach((item) => {
                item.isHit = item.isHit || cc.Intersection.lineRect(prevPos, curPos, item.rect);
            });
        }
    },

    reset() {
        let mask = this.maskNode.getComponent(cc.Mask);
        mask._graphics.clear();

        this.tempDrawPoints = [];
        this.polygonPointsList = [];
        this.progerss.string = '已经刮开了 0%';
        this.ticketNode.getComponent(cc.Graphics).clear();

        // 生成小格子，用来辅助统计涂层的刮开比例
        for (let x = 0; x < this.ticketNode.width; x += CALC_RECT_WIDTH) {
            for (let y = 0; y < this.ticketNode.height; y += CALC_RECT_WIDTH) {
                this.polygonPointsList.push({
                    rect: cc.rect(x - this.ticketNode.width / 2, y - this.ticketNode.height / 2, CALC_RECT_WIDTH, CALC_RECT_WIDTH),
                    isHit: false
                });
            }
        }
    }
});
