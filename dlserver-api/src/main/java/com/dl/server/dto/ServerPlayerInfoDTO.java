package com.dl.server.dto;

public class ServerPlayerInfoDTO extends BaseDTO {

	public int playerid;    //玩家ID，serverid+custno
	public int serverid;    //serverid
	public int custno;    //custno
	public int playernick;    //playernick
	public int logindate;    //logindate
	public int logintime;    //logintime
	public int level;    //level

	public int getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public int getServerid() {
		return this.serverid;
	}

	public void setServerid(int serverid) {
		this.serverid = serverid;
	}

	public int getCustno() {
		return this.custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getPlayernick() {
		return this.playernick;
	}

	public void setPlayernick(int playernick) {
		this.playernick = playernick;
	}

	public int getLogindate() {
		return this.logindate;
	}

	public void setLogindate(int logindate) {
		this.logindate = logindate;
	}

	public int getLogintime() {
		return this.logintime;
	}

	public void setLogintime(int logintime) {
		this.logintime = logintime;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
