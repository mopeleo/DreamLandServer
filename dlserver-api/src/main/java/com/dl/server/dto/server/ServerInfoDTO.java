package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerInfoDTO extends BaseDTO {

	private String serverid;    //服务器ID
	private String servername;    //服务器名称
	private String opendate;    //开服日期
	private String opentime;    //开服时间
	private Integer maxplayer;    //最大玩家数
	private Integer regplayer;    //注册玩家数
	private Integer onlineplayer;    //在线玩家数
	private Integer status;    //服务器状态0，未开，1，以开，2，维护中

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

	public Integer getMaxplayer() {
		return this.maxplayer;
	}

	public void setMaxplayer(Integer maxplayer) {
		this.maxplayer = maxplayer;
	}

	public Integer getRegplayer() {
		return this.regplayer;
	}

	public void setRegplayer(Integer regplayer) {
		this.regplayer = regplayer;
	}

	public Integer getOnlineplayer() {
		return this.onlineplayer;
	}

	public void setOnlineplayer(Integer onlineplayer) {
		this.onlineplayer = onlineplayer;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public void clear(){
		this.serverid = null;
		this.servername = null;
		this.opendate = null;
		this.opentime = null;
		this.maxplayer = null;
		this.regplayer = null;
		this.onlineplayer = null;
		this.status = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", servername=").append(servername);
		sb.append(", opendate=").append(opendate);
		sb.append(", opentime=").append(opentime);
		sb.append(", maxplayer=").append(maxplayer);
		sb.append(", regplayer=").append(regplayer);
		sb.append(", onlineplayer=").append(onlineplayer);
		sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
	}
}
