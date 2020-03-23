package com.dl.server.dao.cust;

import com.dl.server.entity.cust.CustInfoExt;
import java.util.List;

public interface CustInfoExtDao{

    int insert(CustInfoExt entity);

    List<CustInfoExt> selectAll(CustInfoExt where);

}
