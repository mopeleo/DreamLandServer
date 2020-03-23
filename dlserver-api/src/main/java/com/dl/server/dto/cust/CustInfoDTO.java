package com.dl.server.dto.cust;

import com.dl.server.dto.BaseDTO;

public class CustInfoDTO extends BaseDTO {

	private Long custno;    //客户号，自动生成
	private String loginpwd;    //登录密码
	private String salt;    //密码盐，随机生成
	private String nickname;    //用户昵称
	private String status;    //客户状态，0-正常，1-密码错误锁定，2-账号锁定，3-账号冻结
	private String level;    //客户级别
	private String idtype;    //证件类型
	private String idcode;    //证件号码
	private String idname;    //证件姓名
	private String email;    //电子邮件
	private String mobile;    //手机号码
	private String regdate;    //注册日期
	private String lastlogindate;    //上次登录日期
	private String lastlogintime;    //上次登录时间

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getLoginpwd() {
		return this.loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIdtype() {
		return this.idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdcode() {
		return this.idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	public String getIdname() {
		return this.idname;
	}

	public void setIdname(String idname) {
		this.idname = idname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRegdate() {
		return this.regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLastlogindate() {
		return this.lastlogindate;
	}

	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public String getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}


	public void clear(){
		this.custno = null;
		this.loginpwd = null;
		this.salt = null;
		this.nickname = null;
		this.status = null;
		this.level = null;
		this.idtype = null;
		this.idcode = null;
		this.idname = null;
		this.email = null;
		this.mobile = null;
		this.regdate = null;
		this.lastlogindate = null;
		this.lastlogintime = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custno=").append(custno);
		sb.append(", loginpwd=").append(loginpwd);
		sb.append(", salt=").append(salt);
		sb.append(", nickname=").append(nickname);
		sb.append(", status=").append(status);
		sb.append(", level=").append(level);
		sb.append(", idtype=").append(idtype);
		sb.append(", idcode=").append(idcode);
		sb.append(", idname=").append(idname);
		sb.append(", email=").append(email);
		sb.append(", mobile=").append(mobile);
		sb.append(", regdate=").append(regdate);
		sb.append(", lastlogindate=").append(lastlogindate);
		sb.append(", lastlogintime=").append(lastlogintime);
        sb.append("]");
        return sb.toString();
	}
}
