package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerInfoDTO extends BaseDTO {

	private String playerid;    //玩家ID，serverid+custno
	private String serverid;    //serverid
	private int custno;    //custno
	private String playernick;    //playernick
	private String logindate;    //logindate
	private String logintime;    //logintime
	private int level;    //level

	public String getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(String playerid) {
		this.playerid = playerid;
	}

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public int getCustno() {
		return this.custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getPlayernick() {
		return this.playernick;
	}

	public void setPlayernick(String playernick) {
		this.playernick = playernick;
	}

	public String getLogindate() {
		return this.logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	public String getLogintime() {
		return this.logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
