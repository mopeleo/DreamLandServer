package com.dl.server.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysParamDTO extends BaseDTO {

	private String paramid;    //paramid
	private String paramname;    //paramname
	private String paramvalue;    //paramvalue
	private String initvalue;    //initvalue
	private String remark;    //remark

	public String getParamid() {
		return this.paramid;
	}

	public void setParamid(String paramid) {
		this.paramid = paramid;
	}

	public String getParamname() {
		return this.paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public String getInitvalue() {
		return this.initvalue;
	}

	public void setInitvalue(String initvalue) {
		this.initvalue = initvalue;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public void clear(){
		this.paramid = null;
		this.paramname = null;
		this.paramvalue = null;
		this.initvalue = null;
		this.remark = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", paramid=").append(paramid);
		sb.append(", paramname=").append(paramname);
		sb.append(", paramvalue=").append(paramvalue);
		sb.append(", initvalue=").append(initvalue);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
