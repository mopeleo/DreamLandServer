var Dialog = {
    _prefab: null,           // prefab
    _detailLabel:   null,   // 内容
    _cancelButton:  null,   // 确定按钮
    _enterButton:   null,   // 取消按钮
    _enterCallBack: null,   // 回调事件
    _animSpeed:     0.3,    // 动画速度
};

/**
 * detailString :   内容 string 类型.
 * enterCallBack:   确定点击事件回调  function 类型.
 * neeCancel:       是否展示取消按钮 bool 类型 default YES.
 * duration:        动画速度 default = 0.3.
*/
Dialog.show = function (detailString, enterCallBack, needCancel, animSpeed) {
    if (Dialog._prefab != undefined) return;
    Dialog._animSpeed = animSpeed ? animSpeed : Dialog._animSpeed;

    var self = this;
    // 加载 prefab 创建
    cc.loader.loadRes("dialog/dialog", cc.Prefab, function (error, prefab) {
        if (error) {
            cc.error(error);
            return;
        }

        var dialogNode = cc.instantiate(prefab);
        Dialog._prefab = dialogNode;

        dialogNode.on(cc.Node.EventType.TOUCH_START,function(event){
            event.stopPropagation();
        });
        dialogNode.on(cc.Node.EventType.TOUCH_END, function (event) {
            event.stopPropagation();
        });

        // 动画
        var cbFadeOut = cc.callFunc(self.onFadeOutFinish, self);
        var cbFadeIn = cc.callFunc(self.onFadeInFinish, self);
        self.actionFadeIn = cc.sequence(cc.spawn(cc.fadeTo(Dialog._animSpeed, 255), cc.scaleTo(Dialog._animSpeed, 1.0)), cbFadeIn);
        self.actionFadeOut = cc.sequence(cc.spawn(cc.fadeTo(Dialog._animSpeed, 0), cc.scaleTo(Dialog._animSpeed, 2.0)), cbFadeOut);

        // 获取子节点
        Dialog._detailLabel = dialogNode.getChildByName("content").getComponent(cc.Label);
        Dialog._cancelButton = dialogNode.getChildByName("cancelBtn");
        Dialog._enterButton = dialogNode.getChildByName("enterBtn");

        // 添加点击事件
        Dialog._enterButton.on(cc.Node.EventType.TOUCH_END, self.onButtonClicked, self);
        Dialog._cancelButton.on(cc.Node.EventType.TOUCH_END, self.onButtonClicked, self);

        // 父视图
        Dialog._prefab.parent = cc.find("Canvas");

        // 展现 Dialog
        self.startFadeIn();

        // 参数
        self.configDialog(detailString, enterCallBack, needCancel, animSpeed);

    });

    // 参数
    self.configDialog = function (detailString, enterCallBack, needCancel, animSpeed) {

        // 回调
        Dialog._enterCallBack = enterCallBack;

        // 内容
        Dialog._detailLabel.string = detailString;
        // 是否需要取消按钮
        if (needCancel || needCancel == undefined) { // 显示
            Dialog._cancelButton.active = true;
        } else {  // 隐藏
            Dialog._cancelButton.active = false;
            Dialog._enterButton.x = 0;
        }
    };

    // 执行弹进动画
    self.startFadeIn = function () {
        cc.eventManager.pauseTarget(Dialog._prefab, true);
        Dialog._prefab.position = cc.v2(0, 0);
        // Dialog._prefab.setScale(2);
        Dialog._prefab.opacity = 0;
        Dialog._prefab.runAction(self.actionFadeIn);
    };

    // 执行弹出动画
    self.startFadeOut = function () {
        cc.log("startfadeout");
        cc.eventManager.pauseTarget(Dialog._prefab, true);
        Dialog._prefab.runAction(self.actionFadeOut);
    };

    // 弹进动画完成回调
    self.onFadeInFinish = function () {
        cc.eventManager.resumeTarget(Dialog._prefab, true);
    };

    // 弹出动画完成回调
    self.onFadeOutFinish = function () {
        self.onDestory();
    };

    // 按钮点击事件
    self.onButtonClicked = function(event){
        cc.log("onclick");
        if(event.target.name == "enterBtn"){
            if(self._enterCallBack){
                self._enterCallBack();
            }
            cc.log("enterBtn");
        }
        self.startFadeOut();
    };

    // 销毁 Dialog (内存管理还没搞懂，暂且这样写吧~v~)
    self.onDestory = function () {
        Dialog._prefab.destroy();
        Dialog._enterCallBack = null;
        Dialog._prefab = null;
        Dialog._detailLabel = null;
        Dialog._cancelButton = null;
        Dialog._enterButton = null;
        Dialog._animSpeed = 0.3;
    };
};

