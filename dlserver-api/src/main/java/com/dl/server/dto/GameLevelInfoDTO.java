package com.dl.server.dto;

public class GameLevelInfoDTO extends BaseDTO {

	public int levelid;    //levelid
	public int levelname;    //levelname
	public int icon;    //icon
	public int minpoint;    //minpoint
	public int maxpoint;    //maxpoint
	public int describe;    //describe

	public int getLevelid() {
		return this.levelid;
	}

	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}

	public int getLevelname() {
		return this.levelname;
	}

	public void setLevelname(int levelname) {
		this.levelname = levelname;
	}

	public int getIcon() {
		return this.icon;
	}

	public void setIcon(int icon) {
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

	public int getDescribe() {
		return this.describe;
	}

	public void setDescribe(int describe) {
		this.describe = describe;
	}

}
