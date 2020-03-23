package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerFriend;
import java.util.List;

public interface ServerPlayerFriendDao{

    int insert(ServerPlayerFriend entity);

    List<ServerPlayerFriend> selectAll(ServerPlayerFriend where);

    ServerPlayerFriend selectById(String serverid, Long custno);

    int deleteById(String serverid, Long custno);

    int updateById(ServerPlayerFriend entity);
	
    int dynamicUpdateById(ServerPlayerFriend entity);
}
