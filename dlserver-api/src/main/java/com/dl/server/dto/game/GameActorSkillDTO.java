package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameActorSkillDTO extends BaseDTO {

	private String actorid;    //角色ID
	private String skillid;    //技能ID

	public String getActorid() {
		return this.actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public String getSkillid() {
		return this.skillid;
	}

	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}

}
