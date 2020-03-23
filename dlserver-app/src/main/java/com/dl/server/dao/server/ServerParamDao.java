package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerParam;
import java.util.List;

public interface ServerParamDao{

    int insert(ServerParam entity);

    List<ServerParam> selectAll(ServerParam where);

    ServerParam selectById(String serverid, String paramid);

    int deleteById(String serverid, String paramid);

    int updateById(ServerParam entity);
	
    int dynamicUpdateById(ServerParam entity);
}
