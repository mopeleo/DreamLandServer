package com.dl.server.dao.game;

import com.dl.server.entity.game.GameItemInfo;
import java.util.List;

public interface GameItemInfoDao{

    //int dynamicUpdate(GameItemInfo entity);
    
    //int updateWhere(GameItemInfo entity);
    
    int insert(GameItemInfo entity);

    List<GameItemInfo> selectAll(GameItemInfo entity);

    GameItemInfo selectById(String itemid);

    int deleteById(String itemid);

    int updateById(GameItemInfo entity);
}
