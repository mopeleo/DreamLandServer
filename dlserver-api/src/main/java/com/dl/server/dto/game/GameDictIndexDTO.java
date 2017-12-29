package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameDictIndexDTO extends BaseDTO {

	private int dictcode;    //字典代码
	private String dictname;    //字典名称
	private String dftitem;    //默认值

	public int getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(int dictcode) {
		this.dictcode = dictcode;
	}

	public String getDictname() {
		return this.dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public String getDftitem() {
		return this.dftitem;
	}

	public void setDftitem(String dftitem) {
		this.dftitem = dftitem;
	}

}
