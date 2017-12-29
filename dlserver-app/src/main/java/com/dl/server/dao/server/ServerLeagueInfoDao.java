package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerLeagueInfo;
import java.util.List;

public interface ServerLeagueInfoDao{

    //int dynamicUpdate(ServerLeagueInfo entity);
    
    //int updateWhere(ServerLeagueInfo entity);
    
    int insert(ServerLeagueInfo entity);

    List<ServerLeagueInfo> selectAll(ServerLeagueInfo entity);

    ServerLeagueInfo selectById(String leagueid);

    int deleteById(String leagueid);

    int updateById(ServerLeagueInfo entity);
}
