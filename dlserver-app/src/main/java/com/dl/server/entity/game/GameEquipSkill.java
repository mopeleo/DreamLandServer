package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameEquipSkill extends DLEntity{

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

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameEquipSkill");
		return build.append(this.equipid).append(this.skillid).toString();
	}

    public static String buildEntityKey(String equipid, String skillid){
        StringBuilder build = new StringBuilder("GameEquipSkill");
        return build.append(equipid).append(skillid).toString();
    }
	
	public void clear(){
		this.equipid = null;
		this.skillid = null;
	}
}
