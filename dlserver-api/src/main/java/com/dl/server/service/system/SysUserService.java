package com.dl.server.service.system;

import java.util.List;

import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.system.SysUserDTO;

public interface SysUserService {

    public ResultDTO<SysUserDTO> getById(String userId);
    
    public List<SysUserDTO> query();
}
