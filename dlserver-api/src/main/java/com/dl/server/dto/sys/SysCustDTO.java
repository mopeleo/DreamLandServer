package com.dl.server.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysCustDTO extends BaseDTO {

	private Integer custno;    //客户号，自动生成
	private String loginid;    //登录ID
	private String loginpwd;    //登录密码
	private String nickname;    //用户昵称
	private String idtype;    //证件类型
	private String idcode;    //证件号码
	private String idname;    //证件姓名
	private String birthday;    //出生日期
	private String email;    //电子邮件
	private String mobile;    //手机号码
	private String regdate;    //注册日期

	public Integer getCustno() {
		return this.custno;
	}

	public void setCustno(Integer custno) {
		this.custno = custno;
	}

	public String getLoginid() {
		return this.loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginpwd() {
		return this.loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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


	public void clear(){
		this.custno = null;
		this.loginid = null;
		this.loginpwd = null;
		this.nickname = null;
		this.idtype = null;
		this.idcode = null;
		this.idname = null;
		this.birthday = null;
		this.email = null;
		this.mobile = null;
		this.regdate = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custno=").append(custno);
		sb.append(", loginid=").append(loginid);
		sb.append(", loginpwd=").append(loginpwd);
		sb.append(", nickname=").append(nickname);
		sb.append(", idtype=").append(idtype);
		sb.append(", idcode=").append(idcode);
		sb.append(", idname=").append(idname);
		sb.append(", birthday=").append(birthday);
		sb.append(", email=").append(email);
		sb.append(", mobile=").append(mobile);
		sb.append(", regdate=").append(regdate);
        sb.append("]");
        return sb.toString();
	}
}
