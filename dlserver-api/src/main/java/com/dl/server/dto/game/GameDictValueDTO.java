package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameDictValueDTO extends BaseDTO {

	private Integer dictcode;    //字典代码
	private String itemcode;    //选项代码
	private String itemvalue;    //选项值

	public Integer getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(Integer dictcode) {
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


	public void clear(){
		this.dictcode = null;
		this.itemcode = null;
		this.itemvalue = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dictcode=").append(dictcode);
		sb.append(", itemcode=").append(itemcode);
		sb.append(", itemvalue=").append(itemvalue);
        sb.append("]");
        return sb.toString();
	}
}
