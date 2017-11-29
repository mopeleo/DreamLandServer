package com.dl.server.dto;

public class ServerBulletinDTO extends BaseDTO {

	public int serverid;    //服务器ID
	public int title;    //公告标题
	public int content;    //公告内容
	public int startdate;    //开始日期
	public int enddate;    //结束日期
	public int issuer;    //发布者

	public int getServerid() {
		return this.serverid;
	}

	public void setServerid(int serverid) {
		this.serverid = serverid;
	}

	public int getTitle() {
		return this.title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public int getContent() {
		return this.content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public int getStartdate() {
		return this.startdate;
	}

	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}

	public int getEnddate() {
		return this.enddate;
	}

	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}

	public int getIssuer() {
		return this.issuer;
	}

	public void setIssuer(int issuer) {
		this.issuer = issuer;
	}

}
