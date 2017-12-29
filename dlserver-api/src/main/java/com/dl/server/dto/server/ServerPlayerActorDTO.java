package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerActorDTO extends BaseDTO {

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

}
