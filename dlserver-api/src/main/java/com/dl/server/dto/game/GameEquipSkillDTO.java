package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameEquipSkillDTO extends BaseDTO {

	private String equipid;    //equipid
	private String skillid;    //skillid

	public String getEquipid() {
		return this.equipid;
	}

	public void setEquipid(String equipid) {
		this.equipid = equipid;
	}

	public String getSkillid() {
		return this.skillid;
	}

	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}

}
