package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerBulletin extends DLEntity{

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

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerBulletin");
		return build.append(this.title).toString();
	}

    public static String buildEntityKey(String title){
        StringBuilder build = new StringBuilder("ServerBulletin");
        return build.append(title).toString();
    }
	
	public void clear(){
		this.serverid = null;
		this.title = null;
		this.content = null;
		this.startdate = null;
		this.enddate = null;
		this.issuer = null;
	}
}
