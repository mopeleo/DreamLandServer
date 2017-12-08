package com.dl.server.dao.game;

import com.dl.server.entity.game.GameSceneMenu;
import java.util.List;

public interface GameSceneMenuDao{

    GameSceneMenu findUnique(GameSceneMenu entity);
    
    int insert(GameSceneMenu entity);

    List<GameSceneMenu> selectAll();

    GameSceneMenu selectById(Integer sceneid, String menuid);

    int deleteById(Integer sceneid, String menuid);

}
