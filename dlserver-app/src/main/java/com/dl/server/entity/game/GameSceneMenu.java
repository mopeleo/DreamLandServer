package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameSceneMenu extends DLEntity{

	private Integer sceneid;    //sceneid
	private String menuid;    //menuid

	public Integer getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Integer sceneid) {
		this.sceneid = sceneid;
	}

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameSceneMenu");
		return build.append(this.sceneid).append(this.menuid).toString();
	}

    public static String buildEntityKey(Integer sceneid, String menuid){
        StringBuilder build = new StringBuilder("GameSceneMenu");
        return build.append(sceneid).append(menuid).toString();
    }
	
	public void clear(){
		this.sceneid = null;
		this.menuid = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", sceneid=").append(sceneid);
		sb.append(", menuid=").append(menuid);
        sb.append("]");
        return sb.toString();
	}
}
