package com.dl.server.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerPlayerInfo extends DLEntity{

	private String serverid;    //serverid
	private Long custno;    //custno
	private String nickname;    //nickname
	private String logindate;    //logindate
	private String logintime;    //logintime
	private Integer playerlevel;    //玩家等级
	private Integer viplevel;    //会员等级
	private Integer crystal;    //水晶数量，游戏货币

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLogindate() {
		return this.logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	public String getLogintime() {
		return this.logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public Integer getPlayerlevel() {
		return this.playerlevel;
	}

	public void setPlayerlevel(Integer playerlevel) {
		this.playerlevel = playerlevel;
	}

	public Integer getViplevel() {
		return this.viplevel;
	}

	public void setViplevel(Integer viplevel) {
		this.viplevel = viplevel;
	}

	public Integer getCrystal() {
		return this.crystal;
	}

	public void setCrystal(Integer crystal) {
		this.crystal = crystal;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerInfo");
		return build.append(this.serverid).append(this.custno).toString();
	}

    public static String buildEntityKey(String serverid, Long custno){
        StringBuilder build = new StringBuilder("ServerPlayerInfo");
        return build.append(serverid).append(custno).toString();
    }
	
	public void clear(){
		this.serverid = null;
		this.custno = null;
		this.nickname = null;
		this.logindate = null;
		this.logintime = null;
		this.playerlevel = null;
		this.viplevel = null;
		this.crystal = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", nickname=").append(nickname);
		sb.append(", logindate=").append(logindate);
		sb.append(", logintime=").append(logintime);
		sb.append(", playerlevel=").append(playerlevel);
		sb.append(", viplevel=").append(viplevel);
		sb.append(", crystal=").append(crystal);
        sb.append("]");
        return sb.toString();
	}
}
