package com.dl.server.dto;

public class SysArticleDTO extends BaseDTO {

	public int artid;    //文章ID
	public int title;    //标题
	public int author;    //作者
	public int content;    //内容
	public int pubflag;    //发表标志
	public int pubdate;    //发表日期
	public int pubtime;    //发表时间
	public int lastreplydate;    //最新回复日期
	public int lastreplytime;    //最新回复时间
	public int readtimes;    //阅读次数
	public int replytimes;    //回复次数
	public int topflag;    //置顶标志
	public int checkflag;    //复核标志
	public int checker;    //复核人
	public int closeflag;    //关闭标志
	public int closer;    //关闭人

	public int getArtid() {
		return this.artid;
	}

	public void setArtid(int artid) {
		this.artid = artid;
	}

	public int getTitle() {
		return this.title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public int getAuthor() {
		return this.author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getContent() {
		return this.content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public int getPubflag() {
		return this.pubflag;
	}

	public void setPubflag(int pubflag) {
		this.pubflag = pubflag;
	}

	public int getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(int pubdate) {
		this.pubdate = pubdate;
	}

	public int getPubtime() {
		return this.pubtime;
	}

	public void setPubtime(int pubtime) {
		this.pubtime = pubtime;
	}

	public int getLastreplydate() {
		return this.lastreplydate;
	}

	public void setLastreplydate(int lastreplydate) {
		this.lastreplydate = lastreplydate;
	}

	public int getLastreplytime() {
		return this.lastreplytime;
	}

	public void setLastreplytime(int lastreplytime) {
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

	public int getTopflag() {
		return this.topflag;
	}

	public void setTopflag(int topflag) {
		this.topflag = topflag;
	}

	public int getCheckflag() {
		return this.checkflag;
	}

	public void setCheckflag(int checkflag) {
		this.checkflag = checkflag;
	}

	public int getChecker() {
		return this.checker;
	}

	public void setChecker(int checker) {
		this.checker = checker;
	}

	public int getCloseflag() {
		return this.closeflag;
	}

	public void setCloseflag(int closeflag) {
		this.closeflag = closeflag;
	}

	public int getCloser() {
		return this.closer;
	}

	public void setCloser(int closer) {
		this.closer = closer;
	}

}
