package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GamePromotionInfo extends DLEntity{

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

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GamePromotionInfo");
		return build.append(this.promid).toString();
	}

    public static String buildEntityKey(int promid){
        StringBuilder build = new StringBuilder("GamePromotionInfo");
        return build.append(promid).toString();
    }
	
	public void clear(){
		this.promid = 0;
		this.promname = null;
		this.remark = null;
	}
}
