package com.dl.server.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysArticleReplyDTO extends BaseDTO {

	private int artid;    //artid
	private int replyid;    //replyid
	private String content;    //content
	private int replyer;    //replyer
	private String replydate;    //replydate
	private String replytime;    //replytime

	public int getArtid() {
		return this.artid;
	}

	public void setArtid(int artid) {
		this.artid = artid;
	}

	public int getReplyid() {
		return this.replyid;
	}

	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReplyer() {
		return this.replyer;
	}

	public void setReplyer(int replyer) {
		this.replyer = replyer;
	}

	public String getReplydate() {
		return this.replydate;
	}

	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}

	public String getReplytime() {
		return this.replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

}
