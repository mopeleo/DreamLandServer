package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameEquipInfo extends DLEntity{

	private String equipid;    //装备ID
	private String equipname;    //装备名称
	private String icon;    //图标
	private String remark;    //描述
	private String position;    //部位
	private String rank;    //等级

	public String getEquipid() {
		return this.equipid;
	}

	public void setEquipid(String equipid) {
		this.equipid = equipid;
	}

	public String getEquipname() {
		return this.equipname;
	}

	public void setEquipname(String equipname) {
		this.equipname = equipname;
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

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameEquipInfo");
		return build.append(this.equipid).toString();
	}

    public static String buildEntityKey(String equipid){
        StringBuilder build = new StringBuilder("GameEquipInfo");
        return build.append(equipid).toString();
    }
	
	public void clear(){
		this.equipid = null;
		this.equipname = null;
		this.icon = null;
		this.remark = null;
		this.position = null;
		this.rank = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", equipid=").append(equipid);
		sb.append(", equipname=").append(equipname);
		sb.append(", icon=").append(icon);
		sb.append(", remark=").append(remark);
		sb.append(", position=").append(position);
		sb.append(", rank=").append(rank);
        sb.append("]");
        return sb.toString();
	}
}
