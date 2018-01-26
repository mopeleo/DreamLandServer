package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerLeagueInfo extends DLEntity{

	private String leagueid;    //leagueid
	private String serverid;    //serverid
	private String leaguename;    //leaguename
	private String remark;    //remark
	private Integer maxleaguer;    //maxleaguer

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

	public Integer getMaxleaguer() {
		return this.maxleaguer;
	}

	public void setMaxleaguer(Integer maxleaguer) {
		this.maxleaguer = maxleaguer;
	}

    public boolean existId(){
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
		this.maxleaguer = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", leagueid=").append(leagueid);
		sb.append(", serverid=").append(serverid);
		sb.append(", leaguename=").append(leaguename);
		sb.append(", remark=").append(remark);
		sb.append(", maxleaguer=").append(maxleaguer);
        sb.append("]");
        return sb.toString();
	}
}
