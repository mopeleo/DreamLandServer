package com.dl.server.service.impl.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dl.base.utils.BeanPropertyCopy;
import com.dl.server.dao.system.SysUserMapper;
import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.system.SysUserDTO;
import com.dl.server.entity.system.SysUser;
import com.dl.server.service.system.SysUserService;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    private static Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserDao;
    
    @Override
    public ResultDTO<SysUserDTO> getById(String userId) {
        SysUser user = sysUserDao.selectByPrimaryKey(userId);
        SysUserDTO dto = BeanPropertyCopy.convert(user, SysUserDTO.class);
        ResultDTO<SysUserDTO> result = new ResultDTO<SysUserDTO>();
        result.addResult(dto);
        result.setRetmsg("success");
        log.debug("++++++++++++ : " + result.getResult().getUsername());
        return result;
    }

    @Override
    public List<SysUserDTO> query() {
        // TODO Auto-generated method stub
        return null;
    }

}
