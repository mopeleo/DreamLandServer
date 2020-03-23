package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysParam;
import java.util.List;

public interface SysParamDao{

    int insert(SysParam entity);

    List<SysParam> selectAll(SysParam where);

    SysParam selectById(String paramid);

    int deleteById(String paramid);

    int updateById(SysParam entity);
	
    int dynamicUpdateById(SysParam entity);
}
