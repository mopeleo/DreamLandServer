package com.dl.server.dto;

public class GameSkillInfoDTO extends BaseDTO {

	public int skillid;    //技能ID
	public int skillname;    //技能名称
	public int icon;    //技能图标
	public int describe;    //技能描述
	public int type;    //技能类型（角色，装备）

	public int getSkillid() {
		return this.skillid;
	}

	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

	public int getSkillname() {
		return this.skillname;
	}

	public void setSkillname(int skillname) {
		this.skillname = skillname;
	}

	public int getIcon() {
		return this.icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getDescribe() {
		return this.describe;
	}

	public void setDescribe(int describe) {
		this.describe = describe;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
