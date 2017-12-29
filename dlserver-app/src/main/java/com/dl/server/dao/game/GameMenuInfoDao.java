package com.dl.server.dao.game;

import com.dl.server.entity.game.GameMenuInfo;
import java.util.List;

public interface GameMenuInfoDao{

    //int dynamicUpdate(GameMenuInfo entity);
    
    //int updateWhere(GameMenuInfo entity);
    
    int insert(GameMenuInfo entity);

    List<GameMenuInfo> selectAll(GameMenuInfo entity);

    GameMenuInfo selectById(String menuid);

    int deleteById(String menuid);

    int updateById(GameMenuInfo entity);
}
