package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameServerInfoDTO extends BaseDTO {

	private String serverid;    //服务器ID
	private String servername;    //服务器名称
	private int sno;    //开服序号
	private String opendate;    //开服日期
	private String opentime;    //开服时间
	private int maxplayer;    //最大玩家数
	private int regplayer;    //注册玩家数
	private int onlineplayer;    //在线玩家数

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getServername() {
		return this.servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public int getSno() {
		return this.sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getOpendate() {
		return this.opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public String getOpentime() {
		return this.opentime;
	}

	public void setOpentime(String opentime) {
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
