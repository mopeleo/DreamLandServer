package com.dl.server.dao.game;

import com.dl.server.entity.game.GameEquipInfo;
import java.util.List;

public interface GameEquipInfoDao{

    int insert(GameEquipInfo entity);

    List<GameEquipInfo> selectAll(GameEquipInfo where);

    GameEquipInfo selectById(String equipid);

    int deleteById(String equipid);

    int updateById(GameEquipInfo entity);
	
    int dynamicUpdateById(GameEquipInfo entity);
}
