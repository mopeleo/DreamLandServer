package com.dl.server.dto;

public class GamePromotionInfoDTO extends BaseDTO {

	public int promid;    //promid
	public int promname;    //promname
	public int describe;    //describe

	public int getPromid() {
		return this.promid;
	}

	public void setPromid(int promid) {
		this.promid = promid;
	}

	public int getPromname() {
		return this.promname;
	}

	public void setPromname(int promname) {
		this.promname = promname;
	}

	public int getDescribe() {
		return this.describe;
	}

	public void setDescribe(int describe) {
		this.describe = describe;
	}

}
