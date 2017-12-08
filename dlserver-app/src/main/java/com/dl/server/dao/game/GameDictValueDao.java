package com.dl.server.dao.game;

import com.dl.server.entity.game.GameDictValue;
import java.util.List;

public interface GameDictValueDao{

    GameDictValue findUnique(GameDictValue entity);
    
    int insert(GameDictValue entity);

    List<GameDictValue> selectAll();

    GameDictValue selectById(Integer dictcode, String itemcode);

    int deleteById(Integer dictcode, String itemcode);

    int updateById(GameDictValue entity);
}
