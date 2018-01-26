package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameServerInfo extends DLEntity{

	private String serverid;    //服务器ID
	private String servername;    //服务器名称
	private Integer sno;    //开服序号
	private String opendate;    //开服日期
	private String opentime;    //开服时间
	private Integer maxplayer;    //最大玩家数
	private Integer regplayer;    //注册玩家数
	private Integer onlineplayer;    //在线玩家数

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

	public Integer getSno() {
		return this.sno;
	}

	public void setSno(Integer sno) {
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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameServerInfo");
		return build.append(this.serverid).toString();
	}

    public static String buildEntityKey(String serverid){
        StringBuilder build = new StringBuilder("GameServerInfo");
        return build.append(serverid).toString();
    }
	
	public void clear(){
		this.serverid = null;
		this.servername = null;
		this.sno = null;
		this.opendate = null;
		this.opentime = null;
		this.maxplayer = null;
		this.regplayer = null;
		this.onlineplayer = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", servername=").append(servername);
		sb.append(", sno=").append(sno);
		sb.append(", opendate=").append(opendate);
		sb.append(", opentime=").append(opentime);
		sb.append(", maxplayer=").append(maxplayer);
		sb.append(", regplayer=").append(regplayer);
		sb.append(", onlineplayer=").append(onlineplayer);
        sb.append("]");
        return sb.toString();
	}
}
