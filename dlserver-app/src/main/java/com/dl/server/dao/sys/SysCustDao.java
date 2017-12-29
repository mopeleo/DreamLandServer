package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysCust;
import java.util.List;

public interface SysCustDao{

    //int dynamicUpdate(SysCust entity);
    
    //int updateWhere(SysCust entity);
    
    int insert(SysCust entity);

    List<SysCust> selectAll(SysCust entity);

    SysCust selectById(Integer custno);

    int deleteById(Integer custno);

    int updateById(SysCust entity);
}
