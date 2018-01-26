package com.dl.server.entity.sys;

import com.dl.server.entity.DLEntity;

public class SysArticle extends DLEntity{

	private Long artid;    //文章ID
	private String title;    //标题
	private Integer author;    //作者
	private String content;    //内容
	private String pubflag;    //发表标志
	private String pubdate;    //发表日期
	private String pubtime;    //发表时间
	private String lastreplydate;    //最新回复日期
	private String lastreplytime;    //最新回复时间
	private Long readtimes;    //阅读次数
	private Integer replytimes;    //回复次数
	private String topflag;    //置顶标志
	private String checkflag;    //复核标志
	private Integer checker;    //复核人
	private String closeflag;    //关闭标志
	private Integer closer;    //关闭人

	public Long getArtid() {
		return this.artid;
	}

	public void setArtid(Long artid) {
		this.artid = artid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAuthor() {
		return this.author;
	}

	public void setAuthor(Integer author) {
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

	public Long getReadtimes() {
		return this.readtimes;
	}

	public void setReadtimes(Long readtimes) {
		this.readtimes = readtimes;
	}

	public Integer getReplytimes() {
		return this.replytimes;
	}

	public void setReplytimes(Integer replytimes) {
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

	public Integer getChecker() {
		return this.checker;
	}

	public void setChecker(Integer checker) {
		this.checker = checker;
	}

	public String getCloseflag() {
		return this.closeflag;
	}

	public void setCloseflag(String closeflag) {
		this.closeflag = closeflag;
	}

	public Integer getCloser() {
		return this.closer;
	}

	public void setCloser(Integer closer) {
		this.closer = closer;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysArticle");
		return build.append(this.artid).toString();
	}

    public static String buildEntityKey(Long artid){
        StringBuilder build = new StringBuilder("SysArticle");
        return build.append(artid).toString();
    }
	
	public void clear(){
		this.artid = null;
		this.title = null;
		this.author = null;
		this.content = null;
		this.pubflag = null;
		this.pubdate = null;
		this.pubtime = null;
		this.lastreplydate = null;
		this.lastreplytime = null;
		this.readtimes = null;
		this.replytimes = null;
		this.topflag = null;
		this.checkflag = null;
		this.checker = null;
		this.closeflag = null;
		this.closer = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", artid=").append(artid);
		sb.append(", title=").append(title);
		sb.append(", author=").append(author);
		sb.append(", content=").append(content);
		sb.append(", pubflag=").append(pubflag);
		sb.append(", pubdate=").append(pubdate);
		sb.append(", pubtime=").append(pubtime);
		sb.append(", lastreplydate=").append(lastreplydate);
		sb.append(", lastreplytime=").append(lastreplytime);
		sb.append(", readtimes=").append(readtimes);
		sb.append(", replytimes=").append(replytimes);
		sb.append(", topflag=").append(topflag);
		sb.append(", checkflag=").append(checkflag);
		sb.append(", checker=").append(checker);
		sb.append(", closeflag=").append(closeflag);
		sb.append(", closer=").append(closer);
        sb.append("]");
        return sb.toString();
	}
}
