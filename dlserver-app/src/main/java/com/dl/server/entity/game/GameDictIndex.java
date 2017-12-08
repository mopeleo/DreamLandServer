package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameDictIndex extends DLEntity{

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

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameDictIndex");
		return build.append(this.dictcode).toString();
	}

    public static String buildEntityKey(int dictcode){
        StringBuilder build = new StringBuilder("GameDictIndex");
        return build.append(dictcode).toString();
    }
	
	public void clear(){
		this.dictcode = 0;
		this.dictname = null;
		this.dftitem = null;
	}
}
