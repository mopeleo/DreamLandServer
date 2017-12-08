package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameActorSkill extends DLEntity{

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

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameActorSkill");
		return build.append(this.actorid).append(this.skillid).toString();
	}

    public static String buildEntityKey(String actorid, String skillid){
        StringBuilder build = new StringBuilder("GameActorSkill");
        return build.append(actorid).append(skillid).toString();
    }
	
	public void clear(){
		this.actorid = null;
		this.skillid = null;
	}
}
