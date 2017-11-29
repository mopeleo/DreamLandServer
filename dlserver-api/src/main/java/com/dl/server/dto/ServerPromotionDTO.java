package com.dl.server.dto;

public class ServerPromotionDTO extends BaseDTO {

	public int serverid;    //serverid
	public int promid;    //promid
	public int startdate;    //startdate
	public int starttime;    //starttime
	public int enddate;    //enddate
	public int endtime;    //endtime

	public int getServerid() {
		return this.serverid;
	}

	public void setServerid(int serverid) {
		this.serverid = serverid;
	}

	public int getPromid() {
		return this.promid;
	}

	public void setPromid(int promid) {
		this.promid = promid;
	}

	public int getStartdate() {
		return this.startdate;
	}

	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}

	public int getStarttime() {
		return this.starttime;
	}

	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}

	public int getEnddate() {
		return this.enddate;
	}

	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}

	public int getEndtime() {
		return this.endtime;
	}

	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}

}
