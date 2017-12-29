package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerLeagueInfoDTO extends BaseDTO {

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

}
