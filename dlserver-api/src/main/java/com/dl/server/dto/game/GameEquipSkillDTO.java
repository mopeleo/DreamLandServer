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


	public void clear(){
		this.equipid = null;
		this.skillid = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", equipid=").append(equipid);
		sb.append(", skillid=").append(skillid);
        sb.append("]");
        return sb.toString();
	}
}
