package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerItemDTO extends BaseDTO {

	private String playid;    //playid
	private String itemid;    //itemid
	private int num;    //num

	public String getPlayid() {
		return this.playid;
	}

	public void setPlayid(String playid) {
		this.playid = playid;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
