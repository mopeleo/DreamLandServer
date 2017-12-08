package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameSceneMenu extends DLEntity{

	private int sceneid;    //sceneid
	private String menuid;    //menuid

	public int getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(int sceneid) {
		this.sceneid = sceneid;
	}

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameSceneMenu");
		return build.append(this.sceneid).append(this.menuid).toString();
	}

    public static String buildEntityKey(int sceneid, String menuid){
        StringBuilder build = new StringBuilder("GameSceneMenu");
        return build.append(sceneid).append(menuid).toString();
    }
	
	public void clear(){
		this.sceneid = 0;
		this.menuid = null;
	}
}
