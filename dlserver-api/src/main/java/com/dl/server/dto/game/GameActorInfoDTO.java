package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameActorInfoDTO extends BaseDTO {

	private String actorid;    //角色ID
	private String actorname;    //角色名称
	private int aptitude;    //资质
	private int attack;    //攻击值
	private int defense;    //物防值
	private int hp;    //生命值
	private int mp;    //魔法值
	private int ep;    //能量值
	private int initrank;    //初始星级
	private int maxrank;    //最大星级
	private int attr;    //属性

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
