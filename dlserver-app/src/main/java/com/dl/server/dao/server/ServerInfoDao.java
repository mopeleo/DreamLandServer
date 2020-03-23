package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerInfo;
import java.util.List;

public interface ServerInfoDao{

    int insert(ServerInfo entity);

    List<ServerInfo> selectAll(ServerInfo where);

    ServerInfo selectById(String serverid);

    int deleteById(String serverid);

    int updateById(ServerInfo entity);
	
    int dynamicUpdateById(ServerInfo entity);
}
