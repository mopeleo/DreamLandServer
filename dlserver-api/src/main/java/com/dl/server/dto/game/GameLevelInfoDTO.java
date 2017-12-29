package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameLevelInfoDTO extends BaseDTO {

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

}
