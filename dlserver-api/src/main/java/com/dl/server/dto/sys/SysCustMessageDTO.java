package com.dl.server.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysCustMessageDTO extends BaseDTO {

	private Integer custno;    //客户号
	private Long msgid;    //消息ID
	private String isread;    //已读标志

	public Integer getCustno() {
		return this.custno;
	}

	public void setCustno(Integer custno) {
		this.custno = custno;
	}

	public Long getMsgid() {
		return this.msgid;
	}

	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}

	public String getIsread() {
		return this.isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}


	public void clear(){
		this.custno = null;
		this.msgid = null;
		this.isread = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custno=").append(custno);
		sb.append(", msgid=").append(msgid);
		sb.append(", isread=").append(isread);
        sb.append("]");
        return sb.toString();
	}
}
