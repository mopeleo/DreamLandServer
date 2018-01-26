package com.dl.server.dao.game;

import com.dl.server.entity.game.GameDictValue;
import java.util.List;

public interface GameDictValueDao{

    int insert(GameDictValue entity);

    List<GameDictValue> selectAll(GameDictValue where);

    GameDictValue selectById(Integer dictcode, String itemcode);

    int deleteById(Integer dictcode, String itemcode);

    int updateById(GameDictValue entity);
	
    int dynamicUpdateById(GameDictValue entity);
}
