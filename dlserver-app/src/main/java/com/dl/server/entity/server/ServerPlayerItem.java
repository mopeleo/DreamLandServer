package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerPlayerItem extends DLEntity{

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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerItem");
		return build.append(this.serverid).append(this.custno).append(this.itemid).toString();
	}

    public static String buildEntityKey(String serverid, Long custno, String itemid){
        StringBuilder build = new StringBuilder("ServerPlayerItem");
        return build.append(serverid).append(custno).append(itemid).toString();
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
