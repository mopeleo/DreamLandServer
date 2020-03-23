package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerLeagueInfo extends DLEntity{

	private String leagueid;    //leagueid
	private String serverid;    //serverid
	private String leaguename;    //联盟名称
	private Integer maxleaguer;    //最大成员数
	private Integer level;    //联盟等级
	private Long creator;    //盟主
	private String createdate;    //createdate
	private String createtime;    //createtime
	private String remark;    //remark

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

	public Integer getMaxleaguer() {
		return this.maxleaguer;
	}

	public void setMaxleaguer(Integer maxleaguer) {
		this.maxleaguer = maxleaguer;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		this.maxleaguer = null;
		this.level = null;
		this.creator = null;
		this.createdate = null;
		this.createtime = null;
		this.remark = null;
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
		sb.append(", maxleaguer=").append(maxleaguer);
		sb.append(", level=").append(level);
		sb.append(", creator=").append(creator);
		sb.append(", createdate=").append(createdate);
		sb.append(", createtime=").append(createtime);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
