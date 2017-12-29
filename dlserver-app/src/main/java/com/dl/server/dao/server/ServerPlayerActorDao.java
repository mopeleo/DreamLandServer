package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerActor;
import java.util.List;

public interface ServerPlayerActorDao{

    //int dynamicUpdate(ServerPlayerActor entity);
    
    //int updateWhere(ServerPlayerActor entity);
    
    int insert(ServerPlayerActor entity);

    List<ServerPlayerActor> selectAll(ServerPlayerActor entity);

    ServerPlayerActor selectById(String playerid, String actorid);

    int deleteById(String playerid, String actorid);

    int updateById(ServerPlayerActor entity);
}
