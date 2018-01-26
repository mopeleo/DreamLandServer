package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerPlayerItem extends DLEntity{

	private String playid;    //playid
	private String itemid;    //itemid
	private Integer num;    //num

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

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerItem");
		return build.append(this.playid).append(this.itemid).toString();
	}

    public static String buildEntityKey(String playid, String itemid){
        StringBuilder build = new StringBuilder("ServerPlayerItem");
        return build.append(playid).append(itemid).toString();
    }
	
	public void clear(){
		this.playid = null;
		this.itemid = null;
		this.num = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", playid=").append(playid);
		sb.append(", itemid=").append(itemid);
		sb.append(", num=").append(num);
        sb.append("]");
        return sb.toString();
	}
}
