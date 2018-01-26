package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameSceneInfo extends DLEntity{

	private Integer sceneid;    //场景ID
	private String scenename;    //场景名称

	public Integer getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Integer sceneid) {
		this.sceneid = sceneid;
	}

	public String getScenename() {
		return this.scenename;
	}

	public void setScenename(String scenename) {
		this.scenename = scenename;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameSceneInfo");
		return build.append(this.sceneid).toString();
	}

    public static String buildEntityKey(Integer sceneid){
        StringBuilder build = new StringBuilder("GameSceneInfo");
        return build.append(sceneid).toString();
    }
	
	public void clear(){
		this.sceneid = null;
		this.scenename = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", sceneid=").append(sceneid);
		sb.append(", scenename=").append(scenename);
        sb.append("]");
        return sb.toString();
	}
}
