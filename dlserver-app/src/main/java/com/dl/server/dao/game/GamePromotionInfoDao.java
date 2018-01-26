package com.dl.server.dao.game;

import com.dl.server.entity.game.GamePromotionInfo;
import java.util.List;

public interface GamePromotionInfoDao{

    int insert(GamePromotionInfo entity);

    List<GamePromotionInfo> selectAll(GamePromotionInfo where);

    GamePromotionInfo selectById(Integer promid);

    int deleteById(Integer promid);

    int updateById(GamePromotionInfo entity);
	
    int dynamicUpdateById(GamePromotionInfo entity);
}
