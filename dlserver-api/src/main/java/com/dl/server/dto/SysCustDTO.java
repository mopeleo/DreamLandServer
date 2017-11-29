package com.dl.server.dto;

public class SysCustDTO extends BaseDTO {

	public int custno;    //客户号，自动生成
	public int loginid;    //登录ID
	public int loginpwd;    //登录密码
	public int nickname;    //用户昵称
	public int idtype;    //证件类型
	public int idcode;    //证件号码
	public int idname;    //证件姓名
	public int birthday;    //出生日期
	public int email;    //电子邮件
	public int mobile;    //手机号码
	public int regdate;    //注册日期

	public int getCustno() {
		return this.custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getLoginid() {
		return this.loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public int getLoginpwd() {
		return this.loginpwd;
	}

	public void setLoginpwd(int loginpwd) {
		this.loginpwd = loginpwd;
	}

	public int getNickname() {
		return this.nickname;
	}

	public void setNickname(int nickname) {
		this.nickname = nickname;
	}

	public int getIdtype() {
		return this.idtype;
	}

	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}

	public int getIdcode() {
		return this.idcode;
	}

	public void setIdcode(int idcode) {
		this.idcode = idcode;
	}

	public int getIdname() {
		return this.idname;
	}

	public void setIdname(int idname) {
		this.idname = idname;
	}

	public int getBirthday() {
		return this.birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public int getEmail() {
		return this.email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public int getMobile() {
		return this.mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int getRegdate() {
		return this.regdate;
	}

	public void setRegdate(int regdate) {
		this.regdate = regdate;
	}

}
