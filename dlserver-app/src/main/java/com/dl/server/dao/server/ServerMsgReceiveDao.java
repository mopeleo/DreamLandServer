package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerMsgReceive;
import java.util.List;

public interface ServerMsgReceiveDao{

    int insert(ServerMsgReceive entity);

    List<ServerMsgReceive> selectAll(ServerMsgReceive where);

    ServerMsgReceive selectById(Long msgid, String serverid);

    int deleteById(Long msgid, String serverid);

    int updateById(ServerMsgReceive entity);
	
    int dynamicUpdateById(ServerMsgReceive entity);
}
