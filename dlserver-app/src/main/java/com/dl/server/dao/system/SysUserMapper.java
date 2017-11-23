package com.dl.server.dao.system;

import com.dl.server.entity.system.SysUser;
import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String userid);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);
}