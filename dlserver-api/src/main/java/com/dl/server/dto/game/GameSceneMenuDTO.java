package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameSceneMenuDTO extends BaseDTO {

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

}
