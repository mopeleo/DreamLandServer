package com.dl.server.dto;

public class GameItemInfoDTO extends BaseDTO {

	public int itemid;    //道具ID
	public int itemname;    //道具名称
	public int icon;    //图标
	public int describe;    //描述
	public int type;    //道具类型
	public int rank;    //等级

	public int getItemid() {
		return this.itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getItemname() {
		return this.itemname;
	}

	public void setItemname(int itemname) {
		this.itemname = itemname;
	}

	public int getIcon() {
		return this.icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getDescribe() {
		return this.describe;
	}

	public void setDescribe(int describe) {
		this.describe = describe;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
