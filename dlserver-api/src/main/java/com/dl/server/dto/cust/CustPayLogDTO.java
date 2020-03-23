package com.dl.server.dto.cust;

import com.dl.server.dto.BaseDTO;

public class CustPayLogDTO extends BaseDTO {

	private String logid;    //logid
	private Long custno;    //custno
	private Long acctno;    //acctno
	private String serverid;    //serverid
	private String direction;    //方向，0 支付，1，退款
	private Double amt;    //金额
	private String otheracct;    //对方账户
	private String paytype;    //支付类型：1，充值，2，购买XX
	private String status;    //状态，0，支付中，1，成功，2，失败
	private String paydate;    //paydate
	private String paytime;    //paytime
	private String summary;    //备注

	public String getLogid() {
		return this.logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public Long getAcctno() {
		return this.acctno;
	}

	public void setAcctno(Long acctno) {
		this.acctno = acctno;
	}

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Double getAmt() {
		return this.amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	public String getOtheracct() {
		return this.otheracct;
	}

	public void setOtheracct(String otheracct) {
		this.otheracct = otheracct;
	}

	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaydate() {
		return this.paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public String getPaytime() {
		return this.paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


	public void clear(){
		this.logid = null;
		this.custno = null;
		this.acctno = null;
		this.serverid = null;
		this.direction = null;
		this.amt = null;
		this.otheracct = null;
		this.paytype = null;
		this.status = null;
		this.paydate = null;
		this.paytime = null;
		this.summary = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", logid=").append(logid);
		sb.append(", custno=").append(custno);
		sb.append(", acctno=").append(acctno);
		sb.append(", serverid=").append(serverid);
		sb.append(", direction=").append(direction);
		sb.append(", amt=").append(amt);
		sb.append(", otheracct=").append(otheracct);
		sb.append(", paytype=").append(paytype);
		sb.append(", status=").append(status);
		sb.append(", paydate=").append(paydate);
		sb.append(", paytime=").append(paytime);
		sb.append(", summary=").append(summary);
        sb.append("]");
        return sb.toString();
	}
}
