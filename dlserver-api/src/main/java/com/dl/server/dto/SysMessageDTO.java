package com.dl.server.dto;

public class SysMessageDTO extends BaseDTO {

	public int msgid;    //消息ID
	public int content;    //消息内容
	public int author;    //作者
	public int senddate;    //发送日期
	public int sendtime;    //发送时间

	public int getMsgid() {
		return this.msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}

	public int getContent() {
		return this.content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public int getAuthor() {
		return this.author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getSenddate() {
		return this.senddate;
	}

	public void setSenddate(int senddate) {
		this.senddate = senddate;
	}

	public int getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(int sendtime) {
		this.sendtime = sendtime;
	}

}
