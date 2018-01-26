package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerLeagueInfo;
import java.util.List;

public interface ServerLeagueInfoDao{

    int insert(ServerLeagueInfo entity);

    List<ServerLeagueInfo> selectAll(ServerLeagueInfo where);

    ServerLeagueInfo selectById(String leagueid);

    int deleteById(String leagueid);

    int updateById(ServerLeagueInfo entity);
	
    int dynamicUpdateById(ServerLeagueInfo entity);
}
