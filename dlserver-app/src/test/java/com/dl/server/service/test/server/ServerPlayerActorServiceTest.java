package com.dl.server.service.test.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.server.ServerPlayerActorDTO;
import com.dl.server.service.server.ServerPlayerActorService;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("classpath*:spring/*.xml") 
@Transactional  //加了@Transactional，会自动回滚，保持数据库的独立
public class ServerPlayerActorServiceTest {

    @Autowired
    private ServerPlayerActorService actorService;

    public ServerPlayerActorDTO getActorDTO(int p, int a) {
        ServerPlayerActorDTO dto = new ServerPlayerActorDTO();
        dto.setPlayerid("000" + p);
        dto.setActorid("000" + a);
        dto.setLevel(p);
        dto.setRank(a);
        return dto;
    }

//    @Test
    public void testSaveActor() {
        for(int i = 20; i < 30; i++){
            ServerPlayerActorDTO dto1 = getActorDTO(i, i);
            actorService.insert(dto1);
        }
    }

//    @Test
    public void testUpdateActor() {
        ServerPlayerActorDTO dto1 = getActorDTO(1, 1);
        dto1.setLevel(10);
        actorService.update(dto1);

        ServerPlayerActorDTO dto2 = getActorDTO(2, 2);
        dto2.setLevel(10);
        actorService.update(dto2);
    }
    
    @Test
    public void testSelectActor() {
        ServerPlayerActorDTO dto1 = getActorDTO(1, 1);
        ResultDTO<ServerPlayerActorDTO> r1 = actorService.select(dto1);
        ServerPlayerActorDTO result1 = r1.getResult();
        Gson gson = new Gson();
        System.out.println(gson.toJson(result1));

        ServerPlayerActorDTO dto2 = getActorDTO(2, 2);
        ResultDTO<ServerPlayerActorDTO> r2 = actorService.select(dto2);
        ServerPlayerActorDTO result2 = r2.getResult();
        System.out.println(gson.toJson(result2));
    }

//    @Test
    public void testDeleteActor(){
        ServerPlayerActorDTO dto2 = getActorDTO(2, 2);
        actorService.delete(dto2.getPlayerid(), dto2.getActorid());        
    }
}
