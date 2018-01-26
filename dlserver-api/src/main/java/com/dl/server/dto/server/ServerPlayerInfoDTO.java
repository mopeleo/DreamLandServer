package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerInfoDTO extends BaseDTO {

	private String playerid;    //玩家ID，serverid+custno
	private String serverid;    //serverid
	private Integer custno;    //custno
	private String playernick;    //playernick
	private String logindate;    //logindate
	private String logintime;    //logintime
	private Integer level;    //level

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

	public Integer getCustno() {
		return this.custno;
	}

	public void setCustno(Integer custno) {
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

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}


	public void clear(){
		this.playerid = null;
		this.serverid = null;
		this.custno = null;
		this.playernick = null;
		this.logindate = null;
		this.logintime = null;
		this.level = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", playerid=").append(playerid);
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", playernick=").append(playernick);
		sb.append(", logindate=").append(logindate);
		sb.append(", logintime=").append(logintime);
		sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
	}
}
