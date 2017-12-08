package com.dl.server.dao.game;

import com.dl.server.entity.game.GameEquipInfo;
import java.util.List;

public interface GameEquipInfoDao{

    GameEquipInfo findUnique(GameEquipInfo entity);
    
    int insert(GameEquipInfo entity);

    List<GameEquipInfo> selectAll();

    GameEquipInfo selectById(String equipid);

    int deleteById(String equipid);

    int updateById(GameEquipInfo entity);
}
