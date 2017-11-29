package com.dl.server.dto;

public class ServerLeagueInfoDTO extends BaseDTO {

	public int leagueid;    //leagueid
	public int serverid;    //serverid
	public int leaguename;    //leaguename
	public int describe;    //describe
	public int maxleaguer;    //maxleaguer

	public int getLeagueid() {
		return this.leagueid;
	}

	public void setLeagueid(int leagueid) {
		this.leagueid = leagueid;
	}

	public int getServerid() {
		return this.serverid;
	}

	public void setServerid(int serverid) {
		this.serverid = serverid;
	}

	public int getLeaguename() {
		return this.leaguename;
	}

	public void setLeaguename(int leaguename) {
		this.leaguename = leaguename;
	}

	public int getDescribe() {
		return this.describe;
	}

	public void setDescribe(int describe) {
		this.describe = describe;
	}

	public int getMaxleaguer() {
		return this.maxleaguer;
	}

	public void setMaxleaguer(int maxleaguer) {
		this.maxleaguer = maxleaguer;
	}

}
