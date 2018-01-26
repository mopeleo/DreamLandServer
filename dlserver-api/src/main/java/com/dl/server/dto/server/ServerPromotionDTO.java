package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPromotionDTO extends BaseDTO {

	private String serverid;    //serverid
	private Integer promid;    //promid
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

	public Integer getPromid() {
		return this.promid;
	}

	public void setPromid(Integer promid) {
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


	public void clear(){
		this.serverid = null;
		this.promid = null;
		this.startdate = null;
		this.starttime = null;
		this.enddate = null;
		this.endtime = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", promid=").append(promid);
		sb.append(", startdate=").append(startdate);
		sb.append(", starttime=").append(starttime);
		sb.append(", enddate=").append(enddate);
		sb.append(", endtime=").append(endtime);
        sb.append("]");
        return sb.toString();
	}
}
