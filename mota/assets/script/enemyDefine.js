module.exports = {
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
    /**
     *  判断是否能杀死敌人，返回0表示无法杀死敌人，大于0则表示攻击次数可以杀死敌人
     *  enemyType 敌人类型
     *  userData 玩家数据
    */
    canKill:function(enemyType, userData){
        var enemyData = this.getEnemy(enemyType);
        if(!enemyData){
            return 0;
        }
        if(enemyData.def >= userData.atk){
            return 0;
        }
        var playerHit = Math.ceil(enemyData.hp/(userData.atk-enemyData.def));
        var enemyHit = (enemyData.ack == userData.def ? -1 : Math.ceil(userData.hp/(enemyData.atk-userData.def)));
        if(enemyHit < 0 || enemyHit > playerHit){
            return playerHit;
        }

        return 0;
    },
    getEnemy:function(enemyType){
        var key = "enemy" + enemyType;
        var enemy = this[key];
        return enemy;
    },
    enemy100:{
        type  : 100,
        hp    : 30,    //血量
        atk   : 18,
        def   : 8,
        exp   : 1,   //经验值
        money : 1
    },
    enemy101:{
        type  : 101,
        hp    : 100,    //血量
        atk   : 20,
        def   : 10,
        exp   : 2,   //经验值
        money : 2
    },
    enemy102:{
        type  : 102,
        hp    : 200,    //血量
        atk   : 32,
        def   : 12,
        exp   : 4,   //经验值
        money : 4
    },
    enemy103:{
        type  : 103,
        hp    : 350,    //血量
        atk   : 50,
        def   : 10,
        exp   : 8,   //经验值
        money : 8
    },
    enemy104:{
        type  : 104,
        hp    : 250,    //血量
        atk   : 30,
        def   : 20,
        exp   : 12,   //经验值
        money : 12
    },
    enemy105:{
        type  : 105,
        hp    : 360,    //血量
        atk   : 32,
        def   : 30,
        exp   : 20,   //经验值
        money : 20
    },
    enemy106:{
        type  : 106,
        hp    : 500,    //血量
        atk   : 50,
        def   : 30,
        exp   : 32,   //经验值
        money : 32
    },
    enemy107:{
        type  : 107,
        hp    : 800,    //血量
        atk   : 60,
        def   : 60,
        exp   : 50,   //经验值
        money : 50
    }
};
