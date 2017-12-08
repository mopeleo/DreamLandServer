package com.dl.server.dao.game;

import com.dl.server.entity.game.GameSceneInfo;
import java.util.List;

public interface GameSceneInfoDao{

    GameSceneInfo findUnique(GameSceneInfo entity);
    
    int insert(GameSceneInfo entity);

    List<GameSceneInfo> selectAll();

    GameSceneInfo selectById(Integer sceneid);

    int deleteById(Integer sceneid);

    int updateById(GameSceneInfo entity);
}
