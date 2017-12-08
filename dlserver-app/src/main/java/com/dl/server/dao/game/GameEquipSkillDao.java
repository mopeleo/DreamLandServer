package com.dl.server.dao.game;

import com.dl.server.entity.game.GameEquipSkill;
import java.util.List;

public interface GameEquipSkillDao{

    GameEquipSkill findUnique(GameEquipSkill entity);
    
    int insert(GameEquipSkill entity);

    List<GameEquipSkill> selectAll();

    GameEquipSkill selectById(String equipid, String skillid);

    int deleteById(String equipid, String skillid);

}
