package com.dl.server.dto;

public class GameSceneInfoDTO extends BaseDTO {

	public int sceneid;    //场景ID
	public int scenename;    //场景名称

	public int getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(int sceneid) {
		this.sceneid = sceneid;
	}

	public int getScenename() {
		return this.scenename;
	}

	public void setScenename(int scenename) {
		this.scenename = scenename;
	}

}
