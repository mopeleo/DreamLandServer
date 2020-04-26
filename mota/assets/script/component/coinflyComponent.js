// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        startPoint: cc.Node,
        endPoint: cc.Node,
        coinPrefab: cc.Prefab,
        count:20,
        radius:130
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        this.coinPool = new cc.NodePool();
        this.initCoinPool(this.count);
    },

    initCoinPool(count) {
        for (let i = 0; i < count; i++) {
            let coin = cc.instantiate(this.coinPrefab);
            this.coinPool.put(coin);
        }
    },

    playAnim() {
        let randomCount = Math.random() * 15 + 10;
        cc.log("randomCount = " + randomCount);
        let stPos = this.startPoint.getPosition();
        let edPos = this.endPoint.getPosition();
        this.playCoinFlyAnim(randomCount, stPos, edPos, this.radius);
    },

    playCoinFlyAnim(count, stPos, edPos, radius) {
        // 确保当前节点池有足够的金币
        const poolSize = this.coinPool.size();
        const reCreateCoinCount = poolSize > count ? 0 : count - poolSize;
        this.initCoinPool(reCreateCoinCount);

        // 生成圆，并且对圆上的点进行排序
        let points = this.getCirclePoints(radius, stPos, count, 60);
        let coinNodeList = points.map(pos => {
            let coin = this.coinPool.get();
            coin.setPosition(stPos);
            this.node.addChild(coin);
            return {
                node: coin,
                stPos: stPos,
                mdPos: pos,
                edPos: edPos,
                dis: pos.sub(edPos).mag()
            };
        });
        coinNodeList = coinNodeList.sort((a, b) => {
            if (a.dis - b.dis > 0) return 1;
            if (a.dis - b.dis < 0) return -1;
            return 0;
        });

        // 执行金币落袋的动画
        coinNodeList.forEach((item, idx) => {
            item.node.runAction(
                cc.sequence(
                    cc.moveTo(0.3, item.mdPos),
                    cc.delayTime(idx * 0.01),
                    cc.moveTo(0.5, item.edPos),
                    cc.callFunc(() => {
                        this.coinPool.put(item.node);
                    })
                )
            );
        });
    },

    /**
     * 以某点为圆心，生成圆周上等分点的坐标
     *
     * @param {number} radius 半径
     * @param {cc.Vec2} pos 圆心坐标
     * @param {number} count 等分点数量
     * @param {number} [randomScope=80] 等分点的随机波动范围
     * @returns {cc.Vec2[]} 返回等分点坐标
     */
    getCirclePoints(radius, pos, count, randomScope) {
        let points = [];
        let radians = (Math.PI / 180) * Math.round(360 / count);
        for (let i = 0; i < count; i++) {
            let x = pos.x + radius * Math.sin(radians * i);
            let y = pos.y + radius * Math.cos(radians * i);
            points.unshift(cc.v3(x + Math.random() * randomScope, y + Math.random() * randomScope, 0));
        }
        return points;
    }

    // update (dt) {},
});
