package com.dl.server.dao.game;

import com.dl.server.entity.game.GameDictValue;
import java.util.List;

public interface GameDictValueDao{

    //int dynamicUpdate(GameDictValue entity);
    
    //int updateWhere(GameDictValue entity);
    
    int insert(GameDictValue entity);

    List<GameDictValue> selectAll(GameDictValue entity);

    GameDictValue selectById(Integer dictcode, String itemcode);

    int deleteById(Integer dictcode, String itemcode);

    int updateById(GameDictValue entity);
}
