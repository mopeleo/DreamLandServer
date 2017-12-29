package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameSkillInfoDTO extends BaseDTO {

	private String skillid;    //技能ID
	private String skillname;    //技能名称
	private String icon;    //技能图标
	private String remark;    //技能描述
	private String type;    //技能类型（角色，装备）

	public String getSkillid() {
		return this.skillid;
	}

	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}

	public String getSkillname() {
		return this.skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
