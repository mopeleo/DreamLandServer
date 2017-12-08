package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameItemInfo extends DLEntity{

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

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameItemInfo");
		return build.append(this.itemid).toString();
	}

    public static String buildEntityKey(String itemid){
        StringBuilder build = new StringBuilder("GameItemInfo");
        return build.append(itemid).toString();
    }
	
	public void clear(){
		this.itemid = null;
		this.itemname = null;
		this.icon = null;
		this.remark = null;
		this.type = 0;
		this.rank = null;
	}
}
