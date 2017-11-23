package com.dl.server.service.system;

import java.util.List;

import com.dl.server.dto.system.SysUserDTO;

public interface SysUserService {

    public SysUserDTO getById(String userId);
    
    public List<SysUserDTO> query();
}
