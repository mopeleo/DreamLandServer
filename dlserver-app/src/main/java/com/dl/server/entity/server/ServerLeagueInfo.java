package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerLeagueInfo extends DLEntity{

	private String leagueid;    //leagueid
	private String serverid;    //serverid
	private String leaguename;    //leaguename
	private String remark;    //remark
	private int maxleaguer;    //maxleaguer

	public String getLeagueid() {
		return this.leagueid;
	}

	public void setLeagueid(String leagueid) {
		this.leagueid = leagueid;
	}

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getLeaguename() {
		return this.leaguename;
	}

	public void setLeaguename(String leaguename) {
		this.leaguename = leaguename;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getMaxleaguer() {
		return this.maxleaguer;
	}

	public void setMaxleaguer(int maxleaguer) {
		this.maxleaguer = maxleaguer;
	}

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerLeagueInfo");
		return build.append(this.leagueid).toString();
	}

    public static String buildEntityKey(String leagueid){
        StringBuilder build = new StringBuilder("ServerLeagueInfo");
        return build.append(leagueid).toString();
    }
	
	public void clear(){
		this.leagueid = null;
		this.serverid = null;
		this.leaguename = null;
		this.remark = null;
		this.maxleaguer = 0;
	}
}
