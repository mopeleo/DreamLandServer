package com.dl.server.dto;

public class GameEquipInfoDTO extends BaseDTO {

	public int equipid;    //装备ID
	public int equipname;    //装备名称
	public int icon;    //图标
	public int describe;    //描述
	public int position;    //部位
	public int rank;    //等级

	public int getEquipid() {
		return this.equipid;
	}

	public void setEquipid(int equipid) {
		this.equipid = equipid;
	}

	public int getEquipname() {
		return this.equipname;
	}

	public void setEquipname(int equipname) {
		this.equipname = equipname;
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

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
