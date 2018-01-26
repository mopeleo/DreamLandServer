package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerActorDTO extends BaseDTO {

	private String playerid;    //玩家ID
	private String actorid;    //角色ID
	private Integer rank;    //星级
	private Integer level;    //等级

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

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}


	public void clear(){
		this.playerid = null;
		this.actorid = null;
		this.rank = null;
		this.level = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", playerid=").append(playerid);
		sb.append(", actorid=").append(actorid);
		sb.append(", rank=").append(rank);
		sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
	}
}
