package com.dl.server.dto;

public class GameServerInfoDTO extends BaseDTO {

	public int serverid;    //服务器ID
	public int servername;    //服务器名称
	public int sno;    //开服序号
	public int opendate;    //开服日期
	public int opentime;    //开服时间
	public int maxplayer;    //最大玩家数
	public int regplayer;    //注册玩家数
	public int onlineplayer;    //在线玩家数

	public int getServerid() {
		return this.serverid;
	}

	public void setServerid(int serverid) {
		this.serverid = serverid;
	}

	public int getServername() {
		return this.servername;
	}

	public void setServername(int servername) {
		this.servername = servername;
	}

	public int getSno() {
		return this.sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getOpendate() {
		return this.opendate;
	}

	public void setOpendate(int opendate) {
		this.opendate = opendate;
	}

	public int getOpentime() {
		return this.opentime;
	}

	public void setOpentime(int opentime) {
		this.opentime = opentime;
	}

	public int getMaxplayer() {
		return this.maxplayer;
	}

	public void setMaxplayer(int maxplayer) {
		this.maxplayer = maxplayer;
	}

	public int getRegplayer() {
		return this.regplayer;
	}

	public void setRegplayer(int regplayer) {
		this.regplayer = regplayer;
	}

	public int getOnlineplayer() {
		return this.onlineplayer;
	}

	public void setOnlineplayer(int onlineplayer) {
		this.onlineplayer = onlineplayer;
	}

}
