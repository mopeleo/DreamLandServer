package com.dl.server.dto;

public class SysArticleReplyDTO extends BaseDTO {

	public int artid;    //artid
	public int replyid;    //replyid
	public int content;    //content
	public int replyer;    //replyer
	public int replydate;    //replydate
	public int replytime;    //replytime

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

	public int getContent() {
		return this.content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public int getReplyer() {
		return this.replyer;
	}

	public void setReplyer(int replyer) {
		this.replyer = replyer;
	}

	public int getReplydate() {
		return this.replydate;
	}

	public void setReplydate(int replydate) {
		this.replydate = replydate;
	}

	public int getReplytime() {
		return this.replytime;
	}

	public void setReplytime(int replytime) {
		this.replytime = replytime;
	}

}
