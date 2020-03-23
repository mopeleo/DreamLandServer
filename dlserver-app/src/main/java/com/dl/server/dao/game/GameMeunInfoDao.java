package com.dl.server.dao.game;

import com.dl.server.entity.game.GameMeunInfo;
import java.util.List;

public interface GameMeunInfoDao{

    int insert(GameMeunInfo entity);

    List<GameMeunInfo> selectAll(GameMeunInfo where);

    GameMeunInfo selectById(String menuid);

    int deleteById(String menuid);

    int updateById(GameMeunInfo entity);
	
    int dynamicUpdateById(GameMeunInfo entity);
}
