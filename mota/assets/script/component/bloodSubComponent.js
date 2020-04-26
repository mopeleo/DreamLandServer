// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

let manager = {
    maxBlood:100,
    hit:10
};

cc.Class({
    extends: cc.Component,

    properties: {
        bloodLab: cc.Label,
        bloodShow: cc.Sprite,
        sheep:cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
        this.bloodLab.string = manager.maxBlood + '/' + manager.maxBlood;
        this.sheep.on(cc.Node.EventType.TOUCH_END, this.touchend, this);
    },

    touchend(event){
        var currentBlood = parseInt(this.bloodLab.string.split('/')[0]);
        if(currentBlood < manager.hit){
            if(currentBlood == 0){
                cc.log('---');
                this.sheep.getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-sprite'));    // 恢复
                this.bloodLab.string = manager.maxBlood + '/' + manager.maxBlood;
                return;
            }else{
                currentBlood = 0;
            }

        }else{
            currentBlood = currentBlood - manager.hit;
        }
        //抖动效果
        cc.tween(this.sheep).by(0.1, {position: cc.v2(5,5)}).by(0.1, {position: cc.v2(-5,-5)}).start();

        this.bloodLab.string = currentBlood  + '/' + manager.maxBlood;
        // 求出血量占比
        let bloodPer = currentBlood / manager.maxBlood;
        // 更改填充范围
        this.bloodShow.fillRange = bloodPer;

        if(currentBlood == 0){
            this.sheep.getComponent(cc.Sprite).setMaterial(0, cc.Material.getBuiltinMaterial('2d-gray-sprite'));    // 变灰
            this.sheep.off(cc.Node.EventType.TOUCH_END, this.touchend, this);   //移除事件
        }
    },
    // update (dt) {},
});
