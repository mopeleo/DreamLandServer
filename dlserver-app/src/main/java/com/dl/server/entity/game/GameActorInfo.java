package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameActorInfo extends DLEntity{

	private String actorid;    //角色ID
	private String actorname;    //角色名称
	private Integer aptitude;    //资质
	private Integer attack;    //攻击值
	private Integer defense;    //物防值
	private Integer hp;    //生命值
	private Integer mp;    //魔法值
	private Integer ep;    //能量值
	private Integer initrank;    //初始星级
	private Integer maxrank;    //最大星级
	private Integer attr;    //属性

	public String getActorid() {
		return this.actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public String getActorname() {
		return this.actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public Integer getAptitude() {
		return this.aptitude;
	}

	public void setAptitude(Integer aptitude) {
		this.aptitude = aptitude;
	}

	public Integer getAttack() {
		return this.attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefense() {
		return this.defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getHp() {
		return this.hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getMp() {
		return this.mp;
	}

	public void setMp(Integer mp) {
		this.mp = mp;
	}

	public Integer getEp() {
		return this.ep;
	}

	public void setEp(Integer ep) {
		this.ep = ep;
	}

	public Integer getInitrank() {
		return this.initrank;
	}

	public void setInitrank(Integer initrank) {
		this.initrank = initrank;
	}

	public Integer getMaxrank() {
		return this.maxrank;
	}

	public void setMaxrank(Integer maxrank) {
		this.maxrank = maxrank;
	}

	public Integer getAttr() {
		return this.attr;
	}

	public void setAttr(Integer attr) {
		this.attr = attr;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameActorInfo");
		return build.append(this.actorid).toString();
	}

    public static String buildEntityKey(String actorid){
        StringBuilder build = new StringBuilder("GameActorInfo");
        return build.append(actorid).toString();
    }
	
	public void clear(){
		this.actorid = null;
		this.actorname = null;
		this.aptitude = null;
		this.attack = null;
		this.defense = null;
		this.hp = null;
		this.mp = null;
		this.ep = null;
		this.initrank = null;
		this.maxrank = null;
		this.attr = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", actorid=").append(actorid);
		sb.append(", actorname=").append(actorname);
		sb.append(", aptitude=").append(aptitude);
		sb.append(", attack=").append(attack);
		sb.append(", defense=").append(defense);
		sb.append(", hp=").append(hp);
		sb.append(", mp=").append(mp);
		sb.append(", ep=").append(ep);
		sb.append(", initrank=").append(initrank);
		sb.append(", maxrank=").append(maxrank);
		sb.append(", attr=").append(attr);
        sb.append("]");
        return sb.toString();
	}
}
