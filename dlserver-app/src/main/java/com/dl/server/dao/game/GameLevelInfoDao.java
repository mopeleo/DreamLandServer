package com.dl.server.dao.game;

import com.dl.server.entity.game.GameLevelInfo;
import java.util.List;

public interface GameLevelInfoDao{

    //int dynamicUpdate(GameLevelInfo entity);
    
    //int updateWhere(GameLevelInfo entity);
    
    int insert(GameLevelInfo entity);

    List<GameLevelInfo> selectAll(GameLevelInfo entity);

    GameLevelInfo selectById(Integer levelid);

    int deleteById(Integer levelid);

    int updateById(GameLevelInfo entity);
}
