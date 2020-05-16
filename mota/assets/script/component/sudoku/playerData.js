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
        //关卡信息
        scene:{
            easy:{
                info_1:{
                    star:1,
                    gold:2,
                    time:30
                }
            },
            normal:{

            },
            hard:{

            },
            challenge:{
                level:7
            }
        }
    },
    param:{
        sceneType: 1,
        sceneIndex: 1
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
