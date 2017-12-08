package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerPlayerActor extends DLEntity{

	private String playerid;    //玩家ID
	private String actorid;    //角色ID
	private int rank;    //星级
	private int level;    //等级

	public String getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(String playerid) {
		this.playerid = playerid;
	}

	public String getActorid() {
		return this.actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerActor");
		return build.append(this.playerid).append(this.actorid).toString();
	}

    public static String buildEntityKey(String playerid, String actorid){
        StringBuilder build = new StringBuilder("ServerPlayerActor");
        return build.append(playerid).append(actorid).toString();
    }
	
	public void clear(){
		this.playerid = null;
		this.actorid = null;
		this.rank = 0;
		this.level = 0;
	}
}
