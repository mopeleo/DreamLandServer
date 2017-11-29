package com.dl.server.dto;

public class GameDictIndexDTO extends BaseDTO {

	public int dictcode;    //字典代码
	public int dictname;    //字典名称
	public int dftitem;    //默认值

	public int getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(int dictcode) {
		this.dictcode = dictcode;
	}

	public int getDictname() {
		return this.dictname;
	}

	public void setDictname(int dictname) {
		this.dictname = dictname;
	}

	public int getDftitem() {
		return this.dftitem;
	}

	public void setDftitem(int dftitem) {
		this.dftitem = dftitem;
	}

}
