package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameSceneInfoDTO extends BaseDTO {

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

}
