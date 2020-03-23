package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerMsgSendDTO extends BaseDTO {

	private Long msgid;    //消息ID
	private String serverid;    //serverid
	private Long custno;    //作者
	private String content;    //消息内容
	private String type;    //类型，0-所有人可见，1，公会可见，2，指定人可见
	private Long receiver;    //receiver
	private String senddate;    //发送日期
	private String sendtime;    //发送时间

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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
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


	public void clear(){
		this.msgid = null;
		this.serverid = null;
		this.custno = null;
		this.content = null;
		this.type = null;
		this.receiver = null;
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
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", content=").append(content);
		sb.append(", type=").append(type);
		sb.append(", receiver=").append(receiver);
		sb.append(", senddate=").append(senddate);
		sb.append(", sendtime=").append(sendtime);
        sb.append("]");
        return sb.toString();
	}
}
