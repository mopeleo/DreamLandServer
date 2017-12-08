package com.dl.server.entity.sys;

import com.dl.server.entity.DLEntity;

public class SysMessage extends DLEntity{

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

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysMessage");
		return build.append(this.msgid).toString();
	}

    public static String buildEntityKey(int msgid){
        StringBuilder build = new StringBuilder("SysMessage");
        return build.append(msgid).toString();
    }
	
	public void clear(){
		this.msgid = 0;
		this.content = null;
		this.author = 0;
		this.senddate = null;
		this.sendtime = null;
	}
}
