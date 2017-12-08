package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerItem;
import java.util.List;

public interface ServerPlayerItemDao{

    ServerPlayerItem findUnique(ServerPlayerItem entity);
    
    int insert(ServerPlayerItem entity);

    List<ServerPlayerItem> selectAll();

    ServerPlayerItem selectById(String playid, String itemid);

    int deleteById(String playid, String itemid);

    int updateById(ServerPlayerItem entity);
}
