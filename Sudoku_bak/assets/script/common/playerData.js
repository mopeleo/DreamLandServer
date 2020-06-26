var encrypt = require("../libs/encrypt/encryptjs");
var secretkey= 'sudoku_j9kdi2H7'; // 加密密钥

module.exports = {
    player:{
        userName:'',
        avatarUrl:'',
        gold: 0,
        star: 0,
        level: 'rank1',
        actor: 'actor_1', //出战角色ID
        //拥有角色
        haveActors:['actor_1'],
        //解锁成就
        haveAchieves:['achieve_1'],
        //持有道具{id:number}
        haveItems:{'item_1': 11,'item_2': 22},
        //关卡信息{star:1, time:30}
        scene:{
            easy:{},
            normal:{},
            hard:{},
            challenge:{level:0}
        }
    },
    param:{
        sceneType: 1,
        sceneIndex: 1,
        challengeBegin: 55,
    },
    getPlayerItemNumber(itemId){
        if(!this.player.haveItems[itemId]){
            return 0;
        }
        return this.player.haveItems[itemId];
    },
    playerItemChange(itemId, changeNumber){
        if(!this.player.haveItems[itemId]){
            this.player.haveItems[itemId] = 0;
        }

        var hold = this.player.haveItems[itemId];
        hold = hold + changeNumber;
        if(hold < 0){
            hold = 0;
        }

        this.player.haveItems[itemId] = hold;
        this.save();
    },
    getPlayerCurrentIndex:function(sceneType){
        var data = null;
        switch(sceneType){
            case 1:
                data = this.player.scene.easy;
                break;
            case 2:
                data = this.player.scene.normal;
                break;
            case 3:
                data = this.player.scene.hard;
                break;
            default:
                data = this.player.scene.easy;
                break;
        }
        return Object.keys(data).length;

    },
    getPlayerSceneData:function(sceneType, sceneIndex){
        var data = null;
        switch(sceneType){
            case 1:
                data = this.player.scene.easy[sceneIndex];
                break;
            case 2:
                data = this.player.scene.normal[sceneIndex];
                break;
            case 3:
                data = this.player.scene.hard[sceneIndex];
                break;
            default:
                data = this.player.scene.easy[sceneIndex];
                break;
        }
        return data;
    },
    getTotalStar:function(sceneType){
        var easyTotal = 0;
        for(var key in this.player.scene.easy){
            easyTotal += this.player.scene.easy[key].star;
        }
        if(sceneType && sceneType == 1){
            return easyTotal;
        }
        var normalTotal = 0;
        for(var key in this.player.scene.normal){
            normalTotal += this.player.scene.normal[key].star;
        }
        if(sceneType && sceneType == 2){
            return normalTotal;
        }
        var hardTotal = 0;
        for(var key in this.player.scene.hard){
            hardTotal += this.player.scene.hard[key].star;
        }
        if(sceneType && sceneType == 3){
            return hardTotal;
        }

        return easyTotal + normalTotal + hardTotal;
    },
    save:function(){
        var encrypted = encrypt.encrypt(JSON.stringify(this.player), secretkey, 256);
        cc.sys.localStorage.setItem("autodata", encrypted);
    },

    load:function(){
        var datastring = datastring = cc.sys.localStorage.getItem("autodata");
        if(datastring && datastring != null){
            this.player = JSON.parse(encrypt.decrypt(datastring, secretkey, 256));
            return true;
        }

        return false;
    },
};
