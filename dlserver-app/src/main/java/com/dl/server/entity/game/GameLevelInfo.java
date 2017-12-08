package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameLevelInfo extends DLEntity{

	private int levelid;    //levelid
	private String levelname;    //levelname
	private String icon;    //icon
	private int minpoint;    //minpoint
	private int maxpoint;    //maxpoint
	private String remark;    //remark

	public int getLevelid() {
		return this.levelid;
	}

	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}

	public String getLevelname() {
		return this.levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getMinpoint() {
		return this.minpoint;
	}

	public void setMinpoint(int minpoint) {
		this.minpoint = minpoint;
	}

	public int getMaxpoint() {
		return this.maxpoint;
	}

	public void setMaxpoint(int maxpoint) {
		this.maxpoint = maxpoint;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameLevelInfo");
		return build.append(this.levelid).toString();
	}

    public static String buildEntityKey(int levelid){
        StringBuilder build = new StringBuilder("GameLevelInfo");
        return build.append(levelid).toString();
    }
	
	public void clear(){
		this.levelid = 0;
		this.levelname = null;
		this.icon = null;
		this.minpoint = 0;
		this.maxpoint = 0;
		this.remark = null;
	}
}
