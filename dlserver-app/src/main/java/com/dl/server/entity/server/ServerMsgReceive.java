package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerMsgReceive extends DLEntity{

	private Long msgid;    //消息ID
	private String serverid;    //serverid
	private Long custno;    //客户号
	private String isread;    //已读标志

	public Long getMsgid() {
		return this.msgid;
	}

	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}

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

	public String getIsread() {
		return this.isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerMsgReceive");
		return build.append(this.msgid).append(this.serverid).toString();
	}

    public static String buildEntityKey(Long msgid, String serverid){
        StringBuilder build = new StringBuilder("ServerMsgReceive");
        return build.append(msgid).append(serverid).toString();
    }
	
	public void clear(){
		this.msgid = null;
		this.serverid = null;
		this.custno = null;
		this.isread = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", msgid=").append(msgid);
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", isread=").append(isread);
        sb.append("]");
        return sb.toString();
	}
}
