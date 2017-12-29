package com.dl.server.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysCustMessageDTO extends BaseDTO {

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

}
