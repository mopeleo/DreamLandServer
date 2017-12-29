package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerFriend;
import java.util.List;

public interface ServerPlayerFriendDao{

    //int dynamicUpdate(ServerPlayerFriend entity);
    
    //int updateWhere(ServerPlayerFriend entity);
    
    int insert(ServerPlayerFriend entity);

    List<ServerPlayerFriend> selectAll(ServerPlayerFriend entity);

    ServerPlayerFriend selectById(String playerid);

    int deleteById(String playerid);

    int updateById(ServerPlayerFriend entity);
}
