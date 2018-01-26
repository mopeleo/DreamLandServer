package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerFriendDTO extends BaseDTO {

	private String playerid;    //玩家ID
	private String friendlist;    //好友列表逗号分隔
	private Integer friendnum;    //好友数量，上限60

	public String getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(String playerid) {
		this.playerid = playerid;
	}

	public String getFriendlist() {
		return this.friendlist;
	}

	public void setFriendlist(String friendlist) {
		this.friendlist = friendlist;
	}

	public Integer getFriendnum() {
		return this.friendnum;
	}

	public void setFriendnum(Integer friendnum) {
		this.friendnum = friendnum;
	}


	public void clear(){
		this.playerid = null;
		this.friendlist = null;
		this.friendnum = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", playerid=").append(playerid);
		sb.append(", friendlist=").append(friendlist);
		sb.append(", friendnum=").append(friendnum);
        sb.append("]");
        return sb.toString();
	}
}
