package com.dl.server.dao.game;

import com.dl.server.entity.game.GameLevelInfo;
import java.util.List;

public interface GameLevelInfoDao{

    GameLevelInfo findUnique(GameLevelInfo entity);
    
    int insert(GameLevelInfo entity);

    List<GameLevelInfo> selectAll();

    GameLevelInfo selectById(Integer levelid);

    int deleteById(Integer levelid);

    int updateById(GameLevelInfo entity);
}
