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
        btnBlast: cc.Node,
    },

    // LIFE-CYCLE CALLBACKS:

    // onLoad () {},

    start () {
        //手动播放动画
        this.blast();

        this.btnBlast.on("touchend", ()=>{
            this.blast();
        });
    },

    blast(){
        var blastNode = this.node.getChildByName("blast");
        blastNode.active = true;
        var blastAnim = blastNode.getComponent(cc.Animation);
        var fadeIn = cc.fadeIn(0);
        var fadeOut = cc.fadeOut(0.5);
        var seq = cc.sequence(fadeIn, fadeOut);
        blastAnim.subBlood = function(){
            this.txtBlood.active = true;
            this.txtBlood.opacity = 255;
            cc.tween(this.txtBlood).to(0.5, {opacity: 0}).start();
            // this.txtBlood.runAction(fadeOut);
        }.bind(this);
        blastAnim.on('finished', ()=>{
            blastNode.active = false;
            this.txtBlood.active = false;
            blastAnim.setCurrentTime(0);
            blastAnim.stop();
        });

        var playAnim = blastAnim.play();
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
