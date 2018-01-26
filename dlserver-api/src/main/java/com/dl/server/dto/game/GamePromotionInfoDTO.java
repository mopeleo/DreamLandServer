package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GamePromotionInfoDTO extends BaseDTO {

	private Integer promid;    //promid
	private String promname;    //promname
	private String remark;    //remark

	public Integer getPromid() {
		return this.promid;
	}

	public void setPromid(Integer promid) {
		this.promid = promid;
	}

	public String getPromname() {
		return this.promname;
	}

	public void setPromname(String promname) {
		this.promname = promname;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public void clear(){
		this.promid = null;
		this.promname = null;
		this.remark = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", promid=").append(promid);
		sb.append(", promname=").append(promname);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
