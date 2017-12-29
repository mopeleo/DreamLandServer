package com.dl.server.dao.game;

import com.dl.server.entity.game.GameEquipSkill;
import java.util.List;

public interface GameEquipSkillDao{

    //int dynamicUpdate(GameEquipSkill entity);
    
    //int updateWhere(GameEquipSkill entity);
    
    int insert(GameEquipSkill entity);

    List<GameEquipSkill> selectAll(GameEquipSkill entity);

    GameEquipSkill selectById(String equipid, String skillid);

    int deleteById(String equipid, String skillid);

}
