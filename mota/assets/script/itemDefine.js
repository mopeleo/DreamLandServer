module.exports = {
    //物品类型,1X-钥匙，2X-门，3X-血，4X-攻防，9X-特殊
    //10-黄钥匙，11-蓝钥匙，12-红钥匙，
    //20-黄门，21-蓝门，22-红门，
    //30-红血，31-蓝血，
    //40-防御宝石，41-攻击宝石
    //50-建筑金钱交易，51-建筑经验交易
    //90-守门精灵
    itemType : [10,11,12,20,21,22,30,31,40,41,90],
    pickItem:function(tiledMap, position, userData){
        for(var i = 0; i < this.itemType.length; i++){
            var type = this.itemType[i];
            var layer = tiledMap.getLayer("layer" + type);
            if(!layer){
                continue;
            }

            if(layer.getTileGIDAt(position)){

                //修改用户数据
                switch(type){
                    case 10:
                        userData.yellowKey++;
                        break;
                    case 11:
                        userData.blueKey++;
                        break;
                    case 12:
                        userData.redKey++;
                        break;
                    //门要判断钥匙是否足够
                    case 20:
                        if(userData.yellowKey < 1){
                            return false;
                        }
                        userData.yellowKey--;
                        break;
                    case 21:
                        if(userData.blueKey < 1){
                            return false;
                        }
                        userData.blueKey--;
                        break;
                    case 22:
                        if(userData.redKey < 1){
                            return false;
                        }
                        userData.redKey--;
                        break;
                    case 30:
                        userData.hp = userData.hp + 200;
                        break;
                    case 31:
                        userData.hp = userData.hp + 500;
                        break;
                    case 40:
                        userData.def = userData.def + 2;
                        break;
                    case 41:
                        userData.atk = userData.atk + 2;
                        break;
                    default:
                        break;
                }

                //从图层清除图块
                var floor = userData.floor;
                layer.setTileGIDAt(0, position.x, position.y);

                //清除的图片添加到已清除列表
                var floorKey = "floor_" + userData.floor;
                var floorItems = userData.disappearItems[floorKey];
                if(floorItems){
                    var items = floorItems[type];
                    if(!items){
                        items = new Array();
                        floorItems[type] = items;
                    }

                    items.push(position);
                }
            }
        }

        return true;
    },
    existItem:function(){

    },
    clearItem:function(){

    },
    initItem:function(tiledMap, userData){
        var floorKey = "floor_" + userData.floor;
        var floorItems = userData.disappearItems[floorKey];
        if(!floorItems){
            floorItems = {};
            userData.disappearItems[floorKey] = floorItems;
        }

        for(var i = 0; i < this.itemType.length; i++){
            var type = this.itemType[i];
            var layer = tiledMap.getLayer("layer" + type);
            if(!layer){
                continue;
            }

            var itemArray = floorItems[type];
            if(!itemArray){
                itemArray = new Array();
                floorItems[type] = itemArray;
                continue;
            }

            for(var j = 0; j < itemArray.length; j++){
                var position = itemArray[j];
                if(layer.getTileGIDAt(position)){
                    layer.setTileGIDAt(0, position.x, position.y);
                }
            }
        }

    },
};
