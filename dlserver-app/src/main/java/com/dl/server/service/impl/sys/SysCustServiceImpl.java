package com.dl.server.service.impl.sys;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dl.base.utils.BeanPropertyCopy;
import com.dl.server.common.redis.RedisCache;
import com.dl.server.dao.sys.SysCustDao;
import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.sys.SysCustDTO;
import com.dl.server.entity.sys.SysCust;
import com.dl.server.service.sys.SysCustService;
import com.dl.server.service.test.sys.SysCustServiceTest;

@Service
@Transactional
public class SysCustServiceImpl implements SysCustService {

    private static Logger log = LoggerFactory.getLogger(SysCustServiceImpl.class);

    @Autowired
    private SysCustDao sysCustDao;
    
    @Override
    public ResultDTO<SysCustDTO> getById(int userId) {
        SysCust user = RedisCache.get(SysCust.buildEntityKey(userId), SysCust.class);
        if(user == null){
            user = sysCustDao.selectById(userId);
            RedisCache.cache(user);
        }
        SysCustDTO dto = BeanPropertyCopy.convert(user, SysCustDTO.class);
        ResultDTO<SysCustDTO> result = new ResultDTO<SysCustDTO>();
        result.addResult(dto);
        result.setRetmsg("success");
        log.debug("++++++++++++ : " + result.getResult().getNickname());
        return result;
    }

    @Override
    public List<SysCustDTO> query() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResultDTO<SysCustDTO> insert(SysCustDTO cust) {
        // TODO Auto-generated method stub
        SysCust entity = BeanPropertyCopy.convert(cust, SysCust.class);
        sysCustDao.insert(entity);
        ResultDTO<SysCustDTO> result = new ResultDTO<SysCustDTO>();
        result.setRetmsg("success");
        result.setSuccess(true);
        return result;
    }

    @Override
    public ResultDTO<SysCustDTO> login(SysCustDTO cust) {
        ResultDTO<SysCustDTO> result = new ResultDTO<SysCustDTO>();
        SysCust cond = new SysCust();
        cond.setLoginid(cust.getLoginid());
        SysCust user = sysCustDao.findUnique(cond);
        if(user == null){
            result.setSuccess(false);
            result.setRetmsg("用户不存在");
            return result;
        }
        if(!user.getLoginpwd().equals(cust.getLoginpwd())){
            result.setSuccess(false);
            result.setRetmsg("用户密码错误");
            return result;
        }
        RedisCache.cache(user);

        SysCustDTO dto = BeanPropertyCopy.convert(user, SysCustDTO.class);
        result.addResult(dto);
        result.setRetmsg("登录成功");
        return result;
    }

}
