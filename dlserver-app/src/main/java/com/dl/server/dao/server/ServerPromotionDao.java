package com.dl.server.dao.server;

import com.dl.server.entity.server.ServerPromotion;
import java.util.List;

public interface ServerPromotionDao{

    //int dynamicUpdate(ServerPromotion entity);
    
    //int updateWhere(ServerPromotion entity);
    
    int insert(ServerPromotion entity);

    List<ServerPromotion> selectAll(ServerPromotion entity);

    ServerPromotion selectById(String serverid, Integer promid);

    int deleteById(String serverid, Integer promid);

    int updateById(ServerPromotion entity);
}
