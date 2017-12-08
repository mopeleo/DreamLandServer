package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPromotion;
import java.util.List;

public interface ServerPromotionDao{

    ServerPromotion findUnique(ServerPromotion entity);
    
    int insert(ServerPromotion entity);

    List<ServerPromotion> selectAll();

    ServerPromotion selectById(String serverid, Integer promid);

    int deleteById(String serverid, Integer promid);

    int updateById(ServerPromotion entity);
}
