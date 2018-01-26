package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameDictValue extends DLEntity{

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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameDictValue");
		return build.append(this.dictcode).append(this.itemcode).toString();
	}

    public static String buildEntityKey(Integer dictcode, String itemcode){
        StringBuilder build = new StringBuilder("GameDictValue");
        return build.append(dictcode).append(itemcode).toString();
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
