package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerFriendDTO extends BaseDTO {

	private String playerid;    //玩家ID
	private String friendlist;    //好友列表逗号分隔
	private int friendnum;    //好友数量，上限60

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

	public int getFriendnum() {
		return this.friendnum;
	}

	public void setFriendnum(int friendnum) {
		this.friendnum = friendnum;
	}

}
