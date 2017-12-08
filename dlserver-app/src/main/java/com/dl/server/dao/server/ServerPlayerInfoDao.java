package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerInfo;
import java.util.List;

public interface ServerPlayerInfoDao{

    ServerPlayerInfo findUnique(ServerPlayerInfo entity);
    
    int insert(ServerPlayerInfo entity);

    List<ServerPlayerInfo> selectAll();

    ServerPlayerInfo selectById(String playerid);

    int deleteById(String playerid);

    int updateById(ServerPlayerInfo entity);
}
