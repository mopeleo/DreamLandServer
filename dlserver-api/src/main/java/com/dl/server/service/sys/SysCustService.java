package com.dl.server.service.sys;

import java.util.List;

import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.sys.SysCustDTO;

public interface SysCustService {

    public ResultDTO<SysCustDTO> getById(int userId);
    
    public List<SysCustDTO> query();
    
    public ResultDTO<SysCustDTO> insert(SysCustDTO cust);
    
    public ResultDTO<SysCustDTO> login(SysCustDTO cust);
}
