package com.dl.server.dao.game;

import com.dl.server.entity.game.GameSceneInfo;
import java.util.List;

public interface GameSceneInfoDao{

    int insert(GameSceneInfo entity);

    List<GameSceneInfo> selectAll(GameSceneInfo where);

    GameSceneInfo selectById(Integer sceneid);

    int deleteById(Integer sceneid);

    int updateById(GameSceneInfo entity);
	
    int dynamicUpdateById(GameSceneInfo entity);
}
