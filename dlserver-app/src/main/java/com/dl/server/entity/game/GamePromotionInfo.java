package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GamePromotionInfo extends DLEntity{

	private Integer promid;    //promid
	private String promname;    //promname
	private String remark;    //remark

	public Integer getPromid() {
		return this.promid;
	}

	public void setPromid(Integer promid) {
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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GamePromotionInfo");
		return build.append(this.promid).toString();
	}

    public static String buildEntityKey(Integer promid){
        StringBuilder build = new StringBuilder("GamePromotionInfo");
        return build.append(promid).toString();
    }
	
	public void clear(){
		this.promid = null;
		this.promname = null;
		this.remark = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", promid=").append(promid);
		sb.append(", promname=").append(promname);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
