package com.dl.server.dto.forum;

import com.dl.server.dto.BaseDTO;

public class ForumArticleReplyDTO extends BaseDTO {

	private String artid;    //artid
	private Long replyid;    //replyid
	private String content;    //content
	private Long replyer;    //replyer
	private String replydate;    //replydate
	private String replytime;    //replytime

	public String getArtid() {
		return this.artid;
	}

	public void setArtid(String artid) {
		this.artid = artid;
	}

	public Long getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Long replyid) {
		this.replyid = replyid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getReplyer() {
		return this.replyer;
	}

	public void setReplyer(Long replyer) {
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


	public void clear(){
		this.artid = null;
		this.replyid = null;
		this.content = null;
		this.replyer = null;
		this.replydate = null;
		this.replytime = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", artid=").append(artid);
		sb.append(", replyid=").append(replyid);
		sb.append(", content=").append(content);
		sb.append(", replyer=").append(replyer);
		sb.append(", replydate=").append(replydate);
		sb.append(", replytime=").append(replytime);
        sb.append("]");
        return sb.toString();
	}
}
