package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysCustMessage;
import java.util.List;

public interface SysCustMessageDao{

    int insert(SysCustMessage entity);

    List<SysCustMessage> selectAll(SysCustMessage where);

    SysCustMessage selectById(Integer custno, Long msgid);

    int deleteById(Integer custno, Long msgid);

    int updateById(SysCustMessage entity);
	
    int dynamicUpdateById(SysCustMessage entity);
}
