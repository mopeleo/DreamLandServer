package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerFriend;
import java.util.List;

public interface ServerPlayerFriendDao{

    int insert(ServerPlayerFriend entity);

    List<ServerPlayerFriend> selectAll(ServerPlayerFriend where);

    ServerPlayerFriend selectById(String playerid);

    int deleteById(String playerid);

    int updateById(ServerPlayerFriend entity);
	
    int dynamicUpdateById(ServerPlayerFriend entity);
}
