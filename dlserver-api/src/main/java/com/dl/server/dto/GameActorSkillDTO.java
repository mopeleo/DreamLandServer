package com.dl.server.dto;

public class GameActorSkillDTO extends BaseDTO {

	public int actorid;    //角色ID
	public int skillid;    //技能ID

	public int getActorid() {
		return this.actorid;
	}

	public void setActorid(int actorid) {
		this.actorid = actorid;
	}

	public int getSkillid() {
		return this.skillid;
	}

	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

}
