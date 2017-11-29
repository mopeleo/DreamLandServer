package com.dl.server.dto;

public class GameDictValueDTO extends BaseDTO {

	public int dictcode;    //字典代码
	public int itemcode;    //选项代码
	public int itemvalue;    //选项值

	public int getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(int dictcode) {
		this.dictcode = dictcode;
	}

	public int getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(int itemcode) {
		this.itemcode = itemcode;
	}

	public int getItemvalue() {
		return this.itemvalue;
	}

	public void setItemvalue(int itemvalue) {
		this.itemvalue = itemvalue;
	}

}
