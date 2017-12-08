package com.dl.server.service.impl.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dl.base.utils.BeanPropertyCopy;
import com.dl.server.common.redis.RedisCache;
import com.dl.server.dao.server.ServerPlayerActorDao;
import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.server.ServerPlayerActorDTO;
import com.dl.server.entity.server.ServerPlayerActor;
import com.dl.server.service.server.ServerPlayerActorService;

@Service
@Transactional
public class ServerPlayerActorServiceImpl implements ServerPlayerActorService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServerPlayerActorDao serverPlayerActorDao;

    @Override
    public ResultDTO<ServerPlayerActorDTO> insert(ServerPlayerActorDTO dto) {
        ServerPlayerActor actor = BeanPropertyCopy.convert(dto, ServerPlayerActor.class);
        int r = serverPlayerActorDao.insert(actor);
        
        ResultDTO<ServerPlayerActorDTO> result = new ResultDTO<ServerPlayerActorDTO>();
        if(r != 1){
            result.setSuccess(false);
            result.setRetcode("0001");
            result.setRetmsg("新增失败");
        }
        return result;
    }

    @Override
    public ResultDTO<ServerPlayerActorDTO> delete(String playId, String actorId) {
        int r = serverPlayerActorDao.deleteById(playId, actorId);
        RedisCache.delete(ServerPlayerActor.buildEntityKey(playId, actorId));
        
        ResultDTO<ServerPlayerActorDTO> result = new ResultDTO<ServerPlayerActorDTO>();
        if(r != 1){
            result.setSuccess(false);
            result.setRetcode("0001");
            result.setRetmsg("删除失败");
        }
        return result;
    }

    @Override
    public ResultDTO<ServerPlayerActorDTO> update(ServerPlayerActorDTO dto) {
        ServerPlayerActor actor = BeanPropertyCopy.convert(dto, ServerPlayerActor.class);
        int r = serverPlayerActorDao.updateById(actor);
        RedisCache.update(actor);
        
        ResultDTO<ServerPlayerActorDTO> result = new ResultDTO<ServerPlayerActorDTO>();
        if(r != 1){
            result.setSuccess(false);
            result.setRetcode("0001");
            result.setRetmsg("修改失败");
        }
        return result;
    }

    @Override
    public ResultDTO<ServerPlayerActorDTO> select(ServerPlayerActorDTO dto) {
        String key = ServerPlayerActor.buildEntityKey(dto.getPlayerid(), dto.getActorid());
        ServerPlayerActor actor = RedisCache.get(key, ServerPlayerActor.class);
        if(actor == null){
            actor = serverPlayerActorDao.selectById(dto.getPlayerid(), dto.getActorid());
            RedisCache.cache(actor);
        }
        
        ResultDTO<ServerPlayerActorDTO> result = new ResultDTO<ServerPlayerActorDTO>();
        if(actor == null){
            result.setSuccess(false);
            result.setRetcode("0001");
            result.setRetmsg("修改失败");
        }else{
            ServerPlayerActorDTO res = BeanPropertyCopy.convert(actor, ServerPlayerActorDTO.class);
            result.addResult(res);
        }
        return result;
    }

}
