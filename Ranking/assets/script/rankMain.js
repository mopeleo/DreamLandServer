let wx = window['wx'];

cc.Class({
    extends: cc.Component,

    properties: {
		content: cc.Node,
		itemPrefab: cc.Prefab,
    },

    // LIFE-CYCLE CALLBACKS:

    onLoad () {
//      if (cc.sys.platform !== cc.sys.WECHAT_GAME_SUB) return;

        if (typeof wx === 'undefined') {
            return;
        }

        // 监听来自主域的消息
        wx.onMessage(data => {
            if (data.message != undefined) {
                if (data.message != 'clear') {
                    this.score = data.message;
                    this.compareScore();
                    this.rankList= [];
//                    this.getPlayerInfo();
                    this.scheduleOnce(function () { this.getFriendInfo() }, 0.25);
                }
                else {
                    this.content.removeAllChildren();
                }
            }
        });
	},

	compareScore() {
        wx.getUserCloudStorage({
            keyList: ['score'],
            success: (res) => {
                if (res.KVDataList.length > 0) {
                    let KVData = res.KVDataList[0];
                    let storedScore = Number(KVData['value']);
                    if (this.score > storedScore) {
                        let newKVData = { key: 'score', value: String(this.score) }
                        this.setNewCloudScore(newKVData);
                    }
                }
                else {
                    let newKVData = { key: 'score', value: String(this.score) }
                    this.setNewCloudScore(newKVData);
                }
            },
            fail: (res) => {
                console.log(res);
            }
        });
    },

    setNewCloudScore(newKVData) {
        wx.setUserCloudStorage({
            KVDataList: [newKVData],
            success: (res) => {
                console.log('update score success!');
            },
            fail: (res) => {
                console.log(res);
            }
        });
    },

	
    getPlayerInfo() {
        wx.getUserInfo({
            openIdList: ['selfOpenId'],
            lang: 'zh_CN',
            success: (res) => {
                let userInfo = res.data[0];
                for (let i = 0; i < 30; i++) {
                    this.rankList.push({
                        nickName: userInfo.nickName,
                        avatarUrl: userInfo.avatarUrl,
                        score: Math.round(Math.random() * 100)
                    });
                }
                this.makeRanks();
            },
            fail: (res) => {
                console.log(res);
            }
        });
    },

    getFriendInfo() {
        wx.getFriendCloudStorage({
            keyList: ['score'],
            success: (res) => {
                for (let i = 0; i < res.data.length; i++) {
                    this.rankList.push({
                        nickName: res.data[i].nickname,
                        avatarUrl: res.data[i].avatarUrl,
                        score: res.data[i].KVDataList[0]['value'],
                    });
                }
                this.makeRanks();
            },
            fail: (res) => {
                console.log(res);
            }
        });
    },

	
    makeRanks() {
        this.rankList.sort((a, b) => {
            return b['score'] - a['score'];
        });
        for (let i = 0; i < this.rankList.length; i++) {
            let nickName = this.rankList[i]['nickName'];
            let avatarUrl = this.rankList[i]['avatarUrl'];
            let score = this.rankList[i]['score'];
            this.createItem(i + 1, nickName, avatarUrl, score);
        }
    },

    createItem(rank, nickName, avatarUrl, score) {
        let item = cc.instantiate(this.itemPrefab);
        item.getChildByName("indexLab").getComponent(cc.Label).string = rank <= 9 ? ' ' + rank : rank;
        cc.loader.load({ url: avatarUrl, type: 'png' }, (err, texture) => {
            if (err) console.error(err);
            item.getChildByName("avatar").getComponent(cc.Sprite).spriteFrame = new cc.SpriteFrame(texture);
        });
        item.getChildByName("nameLab").getComponent(cc.Label).string = nickName;
        item.getChildByName("starLab").getComponent(cc.Label).string = score;
        this.content.addChild(item);
    },

});
