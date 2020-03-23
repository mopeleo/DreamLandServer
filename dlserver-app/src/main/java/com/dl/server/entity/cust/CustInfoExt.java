package com.dl.server.entity.cust;

import com.dl.server.entity.DLEntity;

public class CustInfoExt extends DLEntity{

	private Long custno;    //custno
	private String birthday;    //出生日期
	private String province;    //所在省份
	private String city;    //所在城市
	private String address;    //联系地址
	private String profession;    //职业

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

    public boolean existId(){
        return false;
    }
    
	
	public void clear(){
		this.custno = null;
		this.birthday = null;
		this.province = null;
		this.city = null;
		this.address = null;
		this.profession = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custno=").append(custno);
		sb.append(", birthday=").append(birthday);
		sb.append(", province=").append(province);
		sb.append(", city=").append(city);
		sb.append(", address=").append(address);
		sb.append(", profession=").append(profession);
        sb.append("]");
        return sb.toString();
	}
}
