package com.dl.server.dao.cust;

import com.dl.server.entity.cust.CustPayLog;
import java.util.List;

public interface CustPayLogDao{

    int insert(CustPayLog entity);

    List<CustPayLog> selectAll(CustPayLog where);

    CustPayLog selectById(String logid);

    int deleteById(String logid);

    int updateById(CustPayLog entity);
	
    int dynamicUpdateById(CustPayLog entity);
}
