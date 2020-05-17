module.exports = {
    getInfo:function(type, index){
        var obj = null;
        switch(type){
            case 1:
                obj = this.easy;
                break;
            case 2:
                obj = this.normal;
                break;
            case 3:
                obj = this.hard;
                break;
            default:
                obj = this.challenge;
                break;
        }

        if(index){
            if(type == 1 || type ==2 || type == 3){
                obj = obj["info_" + index];
            }else{
                obj = obj["info"];
            }
        }

        return obj;
    },
    getGame:function(type, index){
        var info = this.getInfo(type);
        var obj = info["game_" + index];
        if(!obj){
            obj = info["game_1"];
        }
        return obj;
    },
    getFull:function(type, index){
        var info = this.getInfo(type);
        var obj = info["full_" + index];
        if(!obj){
            obj = info["full_1"];
        }
        return obj;
    },
    //关卡信息
    easy:{
        name: "初  级",
        total: 2,
        info_1: {
            maxStar: 3,
            maxGold: 100,
            maxError: 3,
            time:0,
        },
        full_1: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],

        game_1: [[1,2,0,4,5,6,7,0,9],
                 [4,5,6,0,8,0,1,2,3],
                 [7,0,9,1,2,3,4,5,6],
                 [2,3,4,0,6,7,0,0,1],
                 [5,0,7,0,9,1,2,0,4],
                 [8,9,1,0,3,4,0,6,7],
                 [0,4,5,0,7,0,9,0,2],
                 [0,7,0,9,1,0,3,0,5],
                 [9,0,2,0,4,0,0,7,8]],

        info_2: {
            maxStar: 3,
            maxGold: 150,
            maxError: 4,
            time:3,
        },
        full_2: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],

        game_2: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],
    },
    normal:{
        name: "中  级",
        total: 2,
        info_1: {
            maxStar: 3,
            maxGold: 100,
            maxError: 3,
            time:0,
        },
        full_1: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],

        game_1: [[1,2,0,4,5,6,7,0,9],
                 [4,5,6,0,8,0,1,2,3],
                 [7,0,9,1,2,3,4,5,6],
                 [2,3,4,0,6,7,0,0,1],
                 [5,0,7,0,9,1,2,0,4],
                 [8,9,1,0,3,4,0,6,7],
                 [0,4,5,0,7,0,9,0,2],
                 [0,7,0,9,1,0,3,0,5],
                 [9,0,2,0,4,0,0,7,8]],

        info_2: {},
        full_2: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],

        game_2: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],
    },
    hard:{
        name: "高  级",
        total: 2,
        info_1: {
            maxStar: 3,
            maxGold: 100,
            maxError: 3,
            time:0,
        },
        full_1: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],

        game_1: [[1,2,0,4,5,6,7,0,9],
                 [4,5,6,0,8,0,1,2,3],
                 [7,0,9,1,2,3,4,5,6],
                 [2,3,4,0,6,7,0,0,1],
                 [5,0,7,0,9,1,2,0,4],
                 [8,9,1,0,3,4,0,6,7],
                 [0,4,5,0,7,0,9,0,2],
                 [0,7,0,9,1,0,3,0,5],
                 [9,0,2,0,4,0,0,7,8]],

        info_2: {},
        full_2: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],

        game_2: [[1,2,3,4,5,6,7,8,9],
                 [4,5,6,7,8,9,1,2,3],
                 [7,8,9,1,2,3,4,5,6],
                 [2,3,4,5,6,7,8,9,1],
                 [5,6,7,8,9,1,2,3,4],
                 [8,9,1,2,3,4,5,6,7],
                 [3,4,5,6,7,8,9,1,2],
                 [6,7,8,9,1,2,3,4,5],
                 [9,1,2,3,4,5,6,7,8]],
    },
    challenge:{
        name: "挑  战",
        total: 71,
        info: {
            maxStar: 4,
            maxGold: 1000,
            maxError: 4,
            time:0,
        },
    },
    //角色信息
    actor:{

    },
    //道具信息
    item:{

    },

};