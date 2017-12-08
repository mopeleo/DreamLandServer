package com.dl.server.dao.game;

import com.dl.server.entity.game.GameItemInfo;
import java.util.List;

public interface GameItemInfoDao{

    GameItemInfo findUnique(GameItemInfo entity);
    
    int insert(GameItemInfo entity);

    List<GameItemInfo> selectAll();

    GameItemInfo selectById(String itemid);

    int deleteById(String itemid);

    int updateById(GameItemInfo entity);
}
