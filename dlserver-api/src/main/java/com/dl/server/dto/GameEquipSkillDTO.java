package com.dl.server.dto;

public class GameEquipSkillDTO extends BaseDTO {

	public int equipid;    //equipid
	public int skillid;    //skillid

	public int getEquipid() {
		return this.equipid;
	}

	public void setEquipid(int equipid) {
		this.equipid = equipid;
	}

	public int getSkillid() {
		return this.skillid;
	}

	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

}
