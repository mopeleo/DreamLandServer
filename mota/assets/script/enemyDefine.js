module.exports = {
    enemyType : [1,2,3,4,5,6,7,8,9],
    existEnemy:function(enemyId, userData){
        var floorKey = "floor_" + userData.floor;
        var killedEnemys = userData.disappearEnemys[floorKey];
        if(killedEnemys && killedEnemys.indexOf(enemyId) > -1){
            return true;
        }
        return false;
    },
    killEnemy:function(enemyId, userData){
        var floorKey = "floor_" + userData.floor;
        var killedEnemys = userData.disappearEnemys[floorKey];
        if(!killedEnemys){
            killedEnemys = new Array();
            userData.disappearEnemys[floorKey] = killedEnemys;
        }
        killedEnemys.push(enemyId);
    },
    enemy1:{
        type  : 1,
        hp    : 30,    //血量
        atk   : 18,
        def   : 8,
        exp   : 1,   //经验值
        money : 1
    },
    enemy2:{
        type  : 2,
        hp    : 100,    //血量
        atk   : 20,
        def   : 10,
        exp   : 2,   //经验值
        money : 2
    },
    enemy3:{
        type  : 3,
        hp    : 200,    //血量
        atk   : 32,
        def   : 12,
        exp   : 4,   //经验值
        money : 4
    },
    enemy4:{
        type  : 4,
        hp    : 350,    //血量
        atk   : 50,
        def   : 10,
        exp   : 8,   //经验值
        money : 8
    },
    enemy5:{
        type  : 5,
        hp    : 250,    //血量
        atk   : 30,
        def   : 20,
        exp   : 12,   //经验值
        money : 12
    },
    enemy6:{
        type  : 6,
        hp    : 360,    //血量
        atk   : 32,
        def   : 30,
        exp   : 20,   //经验值
        money : 20
    },
    enemy7:{
        type  : 7,
        hp    : 500,    //血量
        atk   : 50,
        def   : 30,
        exp   : 32,   //经验值
        money : 32
    },
    enemy8:{
        type  : 8,
        hp    : 800,    //血量
        atk   : 60,
        def   : 60,
        exp   : 50,   //经验值
        money : 50
    },
    getEnemy:function(enemyType){
        var enemy = null;
        switch(enemyType){
            case 1:
                enemy = this.enemy1;
                break;
            case 2:
                enemy = this.enemy2;
                break;
            case 3:
                enemy = this.enemy3;
                break;
            case 4:
                enemy = this.enemy4;
                break;
            case 5:
                enemy = this.enemy5;
                break;
            case 6:
                enemy = this.enemy6;
                break;
            case 7:
                enemy = this.enemy7;
                break;
            case 8:
                enemy = this.enemy8;
                break;
            default:
                break;
        }
        return enemy;
    },
    data : null
};
