package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPromotionDTO extends BaseDTO {

	private String serverid;    //serverid
	private int promid;    //promid
	private String startdate;    //startdate
	private String starttime;    //starttime
	private String enddate;    //enddate
	private String endtime;    //endtime

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public int getPromid() {
		return this.promid;
	}

	public void setPromid(int promid) {
		this.promid = promid;
	}

	public String getStartdate() {
		return this.startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}
