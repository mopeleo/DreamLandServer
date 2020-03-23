package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysDictValue;
import java.util.List;

public interface SysDictValueDao{

    int insert(SysDictValue entity);

    List<SysDictValue> selectAll(SysDictValue where);

    SysDictValue selectById(Integer dictcode, String itemcode);

    int deleteById(Integer dictcode, String itemcode);

    int updateById(SysDictValue entity);
	
    int dynamicUpdateById(SysDictValue entity);
}
