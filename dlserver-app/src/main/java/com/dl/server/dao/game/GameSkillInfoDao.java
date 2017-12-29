package com.dl.server.dao.game;

import com.dl.server.entity.game.GameSkillInfo;
import java.util.List;

public interface GameSkillInfoDao{

    //int dynamicUpdate(GameSkillInfo entity);
    
    //int updateWhere(GameSkillInfo entity);
    
    int insert(GameSkillInfo entity);

    List<GameSkillInfo> selectAll(GameSkillInfo entity);

    GameSkillInfo selectById(String skillid);

    int deleteById(String skillid);

    int updateById(GameSkillInfo entity);
}
