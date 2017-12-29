package com.dl.server.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerBulletinDTO extends BaseDTO {

	private String serverid;    //服务器ID
	private String title;    //公告标题
	private String content;    //公告内容
	private String startdate;    //开始日期
	private String enddate;    //结束日期
	private String issuer;    //发布者

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartdate() {
		return this.startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getIssuer() {
		return this.issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

}
