package com.dl.server.dto;

public class ServerPlayerActorDTO extends BaseDTO {

	public int playerid;    //玩家ID
	public int actorid;    //角色ID
	public int rank;    //星级
	public int level;    //等级

	public int getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public int getActorid() {
		return this.actorid;
	}

	public void setActorid(int actorid) {
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

}
