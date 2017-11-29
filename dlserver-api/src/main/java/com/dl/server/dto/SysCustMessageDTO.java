package com.dl.server.dto;

public class SysCustMessageDTO extends BaseDTO {

	public int custno;    //客户号
	public int msgid;    //消息ID
	public int isread;    //已读标志

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

	public int getIsread() {
		return this.isread;
	}

	public void setIsread(int isread) {
		this.isread = isread;
	}

}
