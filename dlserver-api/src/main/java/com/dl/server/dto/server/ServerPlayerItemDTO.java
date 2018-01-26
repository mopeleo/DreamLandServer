package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerItemDTO extends BaseDTO {

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
