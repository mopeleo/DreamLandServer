package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysMessage;
import java.util.List;

public interface SysMessageDao{

    SysMessage findUnique(SysMessage entity);
    
    int insert(SysMessage entity);

    List<SysMessage> selectAll();

    SysMessage selectById(Integer msgid);

    int deleteById(Integer msgid);

    int updateById(SysMessage entity);
}
