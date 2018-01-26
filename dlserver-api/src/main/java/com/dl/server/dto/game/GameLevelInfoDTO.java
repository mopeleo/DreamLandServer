package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameLevelInfoDTO extends BaseDTO {

	private Integer levelid;    //levelid
	private String levelname;    //levelname
	private String icon;    //icon
	private Integer minpoint;    //minpoint
	private Integer maxpoint;    //maxpoint
	private String remark;    //remark

	public Integer getLevelid() {
		return this.levelid;
	}

	public void setLevelid(Integer levelid) {
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

	public Integer getMinpoint() {
		return this.minpoint;
	}

	public void setMinpoint(Integer minpoint) {
		this.minpoint = minpoint;
	}

	public Integer getMaxpoint() {
		return this.maxpoint;
	}

	public void setMaxpoint(Integer maxpoint) {
		this.maxpoint = maxpoint;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public void clear(){
		this.levelid = null;
		this.levelname = null;
		this.icon = null;
		this.minpoint = null;
		this.maxpoint = null;
		this.remark = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", levelid=").append(levelid);
		sb.append(", levelname=").append(levelname);
		sb.append(", icon=").append(icon);
		sb.append(", minpoint=").append(minpoint);
		sb.append(", maxpoint=").append(maxpoint);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
