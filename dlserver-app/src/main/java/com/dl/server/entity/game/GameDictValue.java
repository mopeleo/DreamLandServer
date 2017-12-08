package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameDictValue extends DLEntity{

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

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameDictValue");
		return build.append(this.dictcode).append(this.itemcode).toString();
	}

    public static String buildEntityKey(int dictcode, String itemcode){
        StringBuilder build = new StringBuilder("GameDictValue");
        return build.append(dictcode).append(itemcode).toString();
    }
	
	public void clear(){
		this.dictcode = 0;
		this.itemcode = null;
		this.itemvalue = null;
	}
}
