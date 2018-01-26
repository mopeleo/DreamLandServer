package com.dl.server.dao.game;

import com.dl.server.entity.game.GameServerInfo;
import java.util.List;

public interface GameServerInfoDao{

    int insert(GameServerInfo entity);

    List<GameServerInfo> selectAll(GameServerInfo where);

    GameServerInfo selectById(String serverid);

    int deleteById(String serverid);

    int updateById(GameServerInfo entity);
	
    int dynamicUpdateById(GameServerInfo entity);
}
