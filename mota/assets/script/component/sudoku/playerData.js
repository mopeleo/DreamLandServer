var encrypt = require("../../encrypt/encryptjs");
var secretkey= 'sudoku_j9kdi2H7'; // 加密密钥

module.exports = {
    player:{
        gold:100,
        star:88,
        level:'rank1',
        fighter:1, //出战角色ID
        //拥有角色
        actor:[],
        //持有道具
        item:{
            tip:3
        },
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
