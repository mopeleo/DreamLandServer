package com.dl.server.dto;

public class GameSceneMenuDTO extends BaseDTO {

	public int sceneid;    //sceneid
	public int menuid;    //menuid

	public int getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(int sceneid) {
		this.sceneid = sceneid;
	}

	public int getMenuid() {
		return this.menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

}
