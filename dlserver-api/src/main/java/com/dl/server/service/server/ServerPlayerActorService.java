package com.dl.server.service.server;

import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.server.ServerPlayerActorDTO;

public interface ServerPlayerActorService {

    ResultDTO<ServerPlayerActorDTO> insert(ServerPlayerActorDTO dto);
    
    ResultDTO<ServerPlayerActorDTO> delete(String playId, String actorId);
    
    ResultDTO<ServerPlayerActorDTO> update(ServerPlayerActorDTO dto);
    
    ResultDTO<ServerPlayerActorDTO> select(ServerPlayerActorDTO dto);
}
