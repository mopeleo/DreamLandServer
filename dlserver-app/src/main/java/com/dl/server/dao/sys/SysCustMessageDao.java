package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysCustMessage;
import java.util.List;

public interface SysCustMessageDao{

    SysCustMessage findUnique(SysCustMessage entity);
    
    int insert(SysCustMessage entity);

    List<SysCustMessage> selectAll();

    SysCustMessage selectById(Integer custno, Integer msgid);

    int deleteById(Integer custno, Integer msgid);

    int updateById(SysCustMessage entity);
}
