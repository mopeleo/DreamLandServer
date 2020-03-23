package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysDictIndex;
import java.util.List;

public interface SysDictIndexDao{

    int insert(SysDictIndex entity);

    List<SysDictIndex> selectAll(SysDictIndex where);

    SysDictIndex selectById(Integer dictcode);

    int deleteById(Integer dictcode);

    int updateById(SysDictIndex entity);
	
    int dynamicUpdateById(SysDictIndex entity);
}
