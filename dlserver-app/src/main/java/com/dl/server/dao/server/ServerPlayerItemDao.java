package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPlayerItem;
import java.util.List;

public interface ServerPlayerItemDao{

    //int dynamicUpdate(ServerPlayerItem entity);
    
    //int updateWhere(ServerPlayerItem entity);
    
    int insert(ServerPlayerItem entity);

    List<ServerPlayerItem> selectAll(ServerPlayerItem entity);

    ServerPlayerItem selectById(String playid, String itemid);

    int deleteById(String playid, String itemid);

    int updateById(ServerPlayerItem entity);
}
