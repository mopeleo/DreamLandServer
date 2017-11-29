package com.dl.server.dto;

public class ServerPlayerFriendDTO extends BaseDTO {

	public int playerid;    //玩家ID
	public int friendlist;    //好友列表逗号分隔
	public int friendnum;    //好友数量，上限60

	public int getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public int getFriendlist() {
		return this.friendlist;
	}

	public void setFriendlist(int friendlist) {
		this.friendlist = friendlist;
	}

	public int getFriendnum() {
		return this.friendnum;
	}

	public void setFriendnum(int friendnum) {
		this.friendnum = friendnum;
	}

}
