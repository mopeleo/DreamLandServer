package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GamePromotionInfoDTO extends BaseDTO {

	private int promid;    //promid
	private String promname;    //promname
	private String remark;    //remark

	public int getPromid() {
		return this.promid;
	}

	public void setPromid(int promid) {
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

}
