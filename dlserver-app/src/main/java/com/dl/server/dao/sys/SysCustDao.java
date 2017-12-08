package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysCust;
import java.util.List;

public interface SysCustDao{

    SysCust findUnique(SysCust entity);
    
    int insert(SysCust entity);

    List<SysCust> selectAll();

    SysCust selectById(Integer custno);

    int deleteById(Integer custno);

    int updateById(SysCust entity);
}
