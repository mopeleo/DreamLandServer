package com.dl.server.dto;

public class ServerPlayerItemDTO extends BaseDTO {

	public int playid;    //playid
	public int itemid;    //itemid
	public int num;    //num

	public int getPlayid() {
		return this.playid;
	}

	public void setPlayid(int playid) {
		this.playid = playid;
	}

	public int getItemid() {
		return this.itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
