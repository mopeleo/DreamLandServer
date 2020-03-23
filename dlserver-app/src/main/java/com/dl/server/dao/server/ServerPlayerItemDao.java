package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerItem;
import java.util.List;

public interface ServerPlayerItemDao{

    int insert(ServerPlayerItem entity);

    List<ServerPlayerItem> selectAll(ServerPlayerItem where);

    ServerPlayerItem selectById(String serverid, Long custno, String itemid);

    int deleteById(String serverid, Long custno, String itemid);

    int updateById(ServerPlayerItem entity);
	
    int dynamicUpdateById(ServerPlayerItem entity);
}
