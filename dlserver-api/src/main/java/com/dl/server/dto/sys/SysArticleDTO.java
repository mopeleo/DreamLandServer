package com.dl.server.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysArticleDTO extends BaseDTO {

	private int artid;    //文章ID
	private String title;    //标题
	private int author;    //作者
	private String content;    //内容
	private String pubflag;    //发表标志
	private String pubdate;    //发表日期
	private String pubtime;    //发表时间
	private String lastreplydate;    //最新回复日期
	private String lastreplytime;    //最新回复时间
	private int readtimes;    //阅读次数
	private int replytimes;    //回复次数
	private String topflag;    //置顶标志
	private String checkflag;    //复核标志
	private int checker;    //复核人
	private String closeflag;    //关闭标志
	private int closer;    //关闭人

	public int getArtid() {
		return this.artid;
	}

	public void setArtid(int artid) {
		this.artid = artid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthor() {
		return this.author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPubflag() {
		return this.pubflag;
	}

	public void setPubflag(String pubflag) {
		this.pubflag = pubflag;
	}

	public String getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getPubtime() {
		return this.pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public String getLastreplydate() {
		return this.lastreplydate;
	}

	public void setLastreplydate(String lastreplydate) {
		this.lastreplydate = lastreplydate;
	}

	public String getLastreplytime() {
		return this.lastreplytime;
	}

	public void setLastreplytime(String lastreplytime) {
		this.lastreplytime = lastreplytime;
	}

	public int getReadtimes() {
		return this.readtimes;
	}

	public void setReadtimes(int readtimes) {
		this.readtimes = readtimes;
	}

	public int getReplytimes() {
		return this.replytimes;
	}

	public void setReplytimes(int replytimes) {
		this.replytimes = replytimes;
	}

	public String getTopflag() {
		return this.topflag;
	}

	public void setTopflag(String topflag) {
		this.topflag = topflag;
	}

	public String getCheckflag() {
		return this.checkflag;
	}

	public void setCheckflag(String checkflag) {
		this.checkflag = checkflag;
	}

	public int getChecker() {
		return this.checker;
	}

	public void setChecker(int checker) {
		this.checker = checker;
	}

	public String getCloseflag() {
		return this.closeflag;
	}

	public void setCloseflag(String closeflag) {
		this.closeflag = closeflag;
	}

	public int getCloser() {
		return this.closer;
	}

	public void setCloser(int closer) {
		this.closer = closer;
	}

}
