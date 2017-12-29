package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameDictValueDTO extends BaseDTO {

	private int dictcode;    //字典代码
	private String itemcode;    //选项代码
	private String itemvalue;    //选项值

	public int getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(int dictcode) {
		this.dictcode = dictcode;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemvalue() {
		return this.itemvalue;
	}

	public void setItemvalue(String itemvalue) {
		this.itemvalue = itemvalue;
	}

}
