package com.dl.server.entity.sys;

import com.dl.server.entity.DLEntity;

public class SysCustMessage extends DLEntity{

	private int custno;    //客户号
	private int msgid;    //消息ID
	private String isread;    //已读标志

	public int getCustno() {
		return this.custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getMsgid() {
		return this.msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}

	public String getIsread() {
		return this.isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysCustMessage");
		return build.append(this.custno).append(this.msgid).toString();
	}

    public static String buildEntityKey(int custno, int msgid){
        StringBuilder build = new StringBuilder("SysCustMessage");
        return build.append(custno).append(msgid).toString();
    }
	
	public void clear(){
		this.custno = 0;
		this.msgid = 0;
		this.isread = null;
	}
}
