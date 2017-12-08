package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameSceneInfo extends DLEntity{

	private int sceneid;    //场景ID
	private String scenename;    //场景名称

	public int getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(int sceneid) {
		this.sceneid = sceneid;
	}

	public String getScenename() {
		return this.scenename;
	}

	public void setScenename(String scenename) {
		this.scenename = scenename;
	}

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameSceneInfo");
		return build.append(this.sceneid).toString();
	}

    public static String buildEntityKey(int sceneid){
        StringBuilder build = new StringBuilder("GameSceneInfo");
        return build.append(sceneid).toString();
    }
	
	public void clear(){
		this.sceneid = 0;
		this.scenename = null;
	}
}
