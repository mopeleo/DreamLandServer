package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerInfo;
import java.util.List;

public interface ServerPlayerInfoDao{

    int insert(ServerPlayerInfo entity);

    List<ServerPlayerInfo> selectAll(ServerPlayerInfo where);

    ServerPlayerInfo selectById(String playerid);

    int deleteById(String playerid);

    int updateById(ServerPlayerInfo entity);
	
    int dynamicUpdateById(ServerPlayerInfo entity);
}
