package com.dl.server.dao.game;

import com.dl.server.entity.game.GameActorInfo;
import java.util.List;

public interface GameActorInfoDao{

    int insert(GameActorInfo entity);

    List<GameActorInfo> selectAll(GameActorInfo where);

    GameActorInfo selectById(String actorid);

    int deleteById(String actorid);

    int updateById(GameActorInfo entity);
	
    int dynamicUpdateById(GameActorInfo entity);
}
