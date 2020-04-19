// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        label: cc.Label,
        richText: cc.RichText,
        typerTimer: 0
    },

    onLoad() {
        this.showRichTextTyper();
    },

    beforeDestroy() {
        // Destroy前确保定时器关闭
        this.typerTimer && clearInterval(this.typerTimer);
    },

    showLabelTyper() {
        let str = '我是LEO\n这是Label打字效果';
        this.richText.string = '';
        this.label.string = '';
        this.makeLaberTyper(str);
    },

    makeLaberTyper(str) {
        let charArr = str.split('');
        let charIdx = 0;

        this.typerTimer && clearInterval(this.typerTimer);
        this.typerTimer = setInterval(() => {
            if (charIdx >= charArr.length) {
                this.typerTimer && clearInterval(this.typerTimer);
            } else {
                charIdx += 1;
                this.label.string = charArr.slice(0, charIdx).join('');
            }
        }, 50);
    },

    showRichTextTyper() {
        let str = '我是<color=#1B262E>LEO</c>\n这是<color=#1B262E>富文本打字机</color>效果';
        this.richText.string = '';
        this.label.string = '';
        this.makeRichTextTyper(str);
    },

    makeRichTextTyper(str) {
        let charArr = str.replace(/<.+?\/?>/g, '').split('');
        let tempStrArr = [str];

        for (let i = charArr.length; i > 1; i--) {
            let curStr = tempStrArr[charArr.length - i];
            let lastIdx = curStr.lastIndexOf(charArr[i - 1]);
            let prevStr = curStr.slice(0, lastIdx);
            let nextStr = curStr.slice(lastIdx + 1, curStr.length);

            tempStrArr.push(prevStr + nextStr);
            cc.log("prevStr = " + prevStr + ", nextStr = " + nextStr + ", tempStrArr = " + tempStrArr);
        }

        this.typerTimer && clearInterval(this.typerTimer);
        this.typerTimer = setInterval(() => {
            if (tempStrArr.length) {
                this.richText.string = tempStrArr.pop();
            } else {
                this.typerTimer && clearInterval(this.typerTimer);
            }
        }, 50);
    },
    // update (dt) {},
});
