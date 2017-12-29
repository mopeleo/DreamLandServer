package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameItemInfoDTO extends BaseDTO {

	private String itemid;    //道具ID
	private String itemname;    //道具名称
	private String icon;    //图标
	private String remark;    //描述
	private int type;    //道具类型
	private String rank;    //等级

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
