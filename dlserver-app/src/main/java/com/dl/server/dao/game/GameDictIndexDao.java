package com.dl.server.dao.game;

import com.dl.server.entity.game.GameDictIndex;
import java.util.List;

public interface GameDictIndexDao{

    int insert(GameDictIndex entity);

    List<GameDictIndex> selectAll(GameDictIndex where);

    GameDictIndex selectById(Integer dictcode);

    int deleteById(Integer dictcode);

    int updateById(GameDictIndex entity);
	
    int dynamicUpdateById(GameDictIndex entity);
}
