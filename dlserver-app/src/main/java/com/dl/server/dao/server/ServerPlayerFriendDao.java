package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerFriend;
import java.util.List;

public interface ServerPlayerFriendDao{

    ServerPlayerFriend findUnique(ServerPlayerFriend entity);
    
    int insert(ServerPlayerFriend entity);

    List<ServerPlayerFriend> selectAll();

    ServerPlayerFriend selectById(String playerid);

    int deleteById(String playerid);

    int updateById(ServerPlayerFriend entity);
}
