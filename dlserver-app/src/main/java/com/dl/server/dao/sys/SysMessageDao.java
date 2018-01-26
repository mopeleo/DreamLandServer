package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysMessage;
import java.util.List;

public interface SysMessageDao{

    int insert(SysMessage entity);

    List<SysMessage> selectAll(SysMessage where);

    SysMessage selectById(Long msgid);

    int deleteById(Long msgid);

    int updateById(SysMessage entity);
	
    int dynamicUpdateById(SysMessage entity);
}
