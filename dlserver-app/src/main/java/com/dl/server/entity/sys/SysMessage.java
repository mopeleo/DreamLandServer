package com.dl.server.entity.sys;

import com.dl.server.entity.DLEntity;

public class SysMessage extends DLEntity{

	private Long msgid;    //消息ID
	private String content;    //消息内容
	private Long author;    //作者
	private String senddate;    //发送日期
	private String sendtime;    //发送时间

	public Long getMsgid() {
		return this.msgid;
	}

	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getAuthor() {
		return this.author;
	}

	public void setAuthor(Long author) {
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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysMessage");
		return build.append(this.msgid).toString();
	}

    public static String buildEntityKey(Long msgid){
        StringBuilder build = new StringBuilder("SysMessage");
        return build.append(msgid).toString();
    }
	
	public void clear(){
		this.msgid = null;
		this.content = null;
		this.author = null;
		this.senddate = null;
		this.sendtime = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", msgid=").append(msgid);
		sb.append(", content=").append(content);
		sb.append(", author=").append(author);
		sb.append(", senddate=").append(senddate);
		sb.append(", sendtime=").append(sendtime);
        sb.append("]");
        return sb.toString();
	}
}
