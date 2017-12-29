package com.dl.server.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysMessageDTO extends BaseDTO {

	private int msgid;    //消息ID
	private String content;    //消息内容
	private int author;    //作者
	private String senddate;    //发送日期
	private String sendtime;    //发送时间

	public int getMsgid() {
		return this.msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAuthor() {
		return this.author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getSenddate() {
		return this.senddate;
	}

	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}

	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

}
