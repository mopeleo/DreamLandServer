package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerParam extends DLEntity{

	private String serverid;    //serverid
	private String paramid;    //paramid
	private String paramvalue;    //paramvalue

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getParamid() {
		return this.paramid;
	}

	public void setParamid(String paramid) {
		this.paramid = paramid;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerParam");
		return build.append(this.serverid).append(this.paramid).toString();
	}

    public static String buildEntityKey(String serverid, String paramid){
        StringBuilder build = new StringBuilder("ServerParam");
        return build.append(serverid).append(paramid).toString();
    }
	
	public void clear(){
		this.serverid = null;
		this.paramid = null;
		this.paramvalue = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", paramid=").append(paramid);
		sb.append(", paramvalue=").append(paramvalue);
        sb.append("]");
        return sb.toString();
	}
}
