package com.dl.server.dao.game;

import com.dl.server.entity.game.GameActorSkill;
import java.util.List;

public interface GameActorSkillDao{

    //int dynamicUpdate(GameActorSkill entity);
    
    //int updateWhere(GameActorSkill entity);
    
    int insert(GameActorSkill entity);

    List<GameActorSkill> selectAll(GameActorSkill entity);

    GameActorSkill selectById(String actorid, String skillid);

    int deleteById(String actorid, String skillid);

}
