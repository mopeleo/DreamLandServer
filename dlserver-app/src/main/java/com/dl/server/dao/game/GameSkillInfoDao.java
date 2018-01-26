package com.dl.server.dao.game;

import com.dl.server.entity.game.GameSkillInfo;
import java.util.List;

public interface GameSkillInfoDao{

    int insert(GameSkillInfo entity);

    List<GameSkillInfo> selectAll(GameSkillInfo where);

    GameSkillInfo selectById(String skillid);

    int deleteById(String skillid);

    int updateById(GameSkillInfo entity);
	
    int dynamicUpdateById(GameSkillInfo entity);
}
