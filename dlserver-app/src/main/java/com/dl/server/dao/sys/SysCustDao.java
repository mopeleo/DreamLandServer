package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysCust;
import java.util.List;

public interface SysCustDao{

    int insert(SysCust entity);

    List<SysCust> selectAll(SysCust where);

    SysCust selectById(Integer custno);

    int deleteById(Integer custno);

    int updateById(SysCust entity);
	
    int dynamicUpdateById(SysCust entity);
}
