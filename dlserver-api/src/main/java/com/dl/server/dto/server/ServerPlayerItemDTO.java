package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerItemDTO extends BaseDTO {

	private String serverid;    //serverid
	private Long custno;    //custno
	private String itemid;    //itemid
	private Integer num;    //num

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
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
		this.serverid = null;
		this.custno = null;
		this.itemid = null;
		this.num = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", itemid=").append(itemid);
		sb.append(", num=").append(num);
        sb.append("]");
        return sb.toString();
	}
}
