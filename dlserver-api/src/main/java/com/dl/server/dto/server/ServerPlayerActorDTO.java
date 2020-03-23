package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerActorDTO extends BaseDTO {

	private String serverid;    //serverid
	private Long custno;    //custno
	private String actorid;    //角色ID
	private Integer rank;    //星级
	private Integer level;    //等级

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getActorid() {
		return this.actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}


	public void clear(){
		this.serverid = null;
		this.custno = null;
		this.actorid = null;
		this.rank = null;
		this.level = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", actorid=").append(actorid);
		sb.append(", rank=").append(rank);
		sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
	}
}
