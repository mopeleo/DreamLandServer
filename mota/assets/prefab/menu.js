var pub = require("../script/pubDefine");

cc.Class({
    extends: cc.Component,

    properties: {
        mask : cc.Node,
		btnReturnGame: cc.Node,
		btnCustSave: cc.Node,
		btnLoadCustSave: cc.Node,
		btnLoadAutoSave: cc.Node,
		btnReturnIndex: cc.Node
    },

    // LIFE-CYCLE CALLBACKS:

    // onLoad () {},

    start () {
		var self = this.node;
		this.btnReturnGame.on('touchend',()=>{
			self.destroy();
		});
		this.btnCustSave.on('touchend',()=>{
			pub.save("1");
			self.destroy();
		});
		this.btnLoadCustSave.on('touchend',()=>{
			var flag = pub.load("1");
			if(flag){
				var floor = "floor" + pub.player.floor;
				cc.director.loadScene(floor);
			}else{
				self.destroy();
			}
		});
		this.btnLoadAutoSave.on('touchend',()=>{
			var flag = pub.load();
			if(flag){
				var floor = "floor" + pub.player.floor;
				cc.director.loadScene(floor);
			}else{
				self.destroy();
			}
		});
		this.btnReturnIndex.on('touchend',()=>{
			self.destroy();
			cc.director.loadScene("index");
		});
    },

// 设置监听事件
    onEnable : function(){

        this.mask.on('touchstart',function(event){
            event.stopPropagation();
        });

        this.mask.on('touchend', function (event) {
            event.stopPropagation();
        });
    },

    // 关闭监听
    onDisable : function(){

        this.mask.off('touchstart',function(event){
            event.stopPropagation();
        });
        this.mask.off('touchend', function (event) {
            event.stopPropagation();
        });
    },
	
});
