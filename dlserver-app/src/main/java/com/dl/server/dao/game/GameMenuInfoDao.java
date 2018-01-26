package com.dl.server.dao.game;

import com.dl.server.entity.game.GameMenuInfo;
import java.util.List;

public interface GameMenuInfoDao{

    int insert(GameMenuInfo entity);

    List<GameMenuInfo> selectAll(GameMenuInfo where);

    GameMenuInfo selectById(String menuid);

    int deleteById(String menuid);

    int updateById(GameMenuInfo entity);
	
    int dynamicUpdateById(GameMenuInfo entity);
}
