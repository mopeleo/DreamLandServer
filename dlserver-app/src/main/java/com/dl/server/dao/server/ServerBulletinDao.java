package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerBulletin;
import java.util.List;

public interface ServerBulletinDao{

    int insert(ServerBulletin entity);

    List<ServerBulletin> selectAll(ServerBulletin where);

    ServerBulletin selectById(String title);

    int deleteById(String title);

    int updateById(ServerBulletin entity);
	
    int dynamicUpdateById(ServerBulletin entity);
}
