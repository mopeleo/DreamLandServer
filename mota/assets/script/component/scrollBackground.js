// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        bg1: cc.Node,
        bg2: cc.Node,
        txtBlood: cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    // onLoad () {},

    start () {
        //手动播放动画
        var blastNode = this.node.getChildByName("blast").getComponent(cc.Animation);
        this.txtBlood.active = false;
        var fadeOut = cc.fadeOut(0.5);
        var fadeIn = cc.fadeIn(0.1);
        var seq = cc.sequence(fadeIn, fadeOut);
        blastNode.subBlood = function(){
            if(!this.txtBlood.active){
                this.txtBlood.active = true;
            }
            this.txtBlood.runAction(seq);
            cc.log("test");
        }.bind(this);
        var playAnim = blastNode.play("blasting");
        playAnim.repeatCount = 1;
    },

    update (dt) {
        var speed = 128;
        var move = dt*speed;
        var backx = (this.bg2.width+this.bg1.width)/2 -2;
        if(this.bg1.x <= (0-backx)){
            this.bg1.x = backx;
        }
        if(this.bg2.x <= (0-backx)){
            this.bg2.x = backx;
        }
        this.bg1.x = this.bg1.x-move;
        this.bg2.x = this.bg2.x-move;
    },
});
