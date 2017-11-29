package com.dl.server.dto;

public class GameActorInfoDTO extends BaseDTO {

	public int actorid;    //角色ID
	public int actorname;    //角色名称
	public int aptitude;    //资质
	public int attack;    //攻击值
	public int defense;    //物防值
	public int hp;    //生命值
	public int mp;    //魔法值
	public int ep;    //能量值
	public int initrank;    //初始星级
	public int maxrank;    //最大星级
	public int attr;    //属性

	public int getActorid() {
		return this.actorid;
	}

	public void setActorid(int actorid) {
		this.actorid = actorid;
	}

	public int getActorname() {
		return this.actorname;
	}

	public void setActorname(int actorname) {
		this.actorname = actorname;
	}

	public int getAptitude() {
		return this.aptitude;
	}

	public void setAptitude(int aptitude) {
		this.aptitude = aptitude;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return this.defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return this.mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getEp() {
		return this.ep;
	}

	public void setEp(int ep) {
		this.ep = ep;
	}

	public int getInitrank() {
		return this.initrank;
	}

	public void setInitrank(int initrank) {
		this.initrank = initrank;
	}

	public int getMaxrank() {
		return this.maxrank;
	}

	public void setMaxrank(int maxrank) {
		this.maxrank = maxrank;
	}

	public int getAttr() {
		return this.attr;
	}

	public void setAttr(int attr) {
		this.attr = attr;
	}

}
