package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameDictIndex extends DLEntity{

	private Integer dictcode;    //字典代码
	private String dictname;    //字典名称
	private String dftitem;    //默认值

	public Integer getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(Integer dictcode) {
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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameDictIndex");
		return build.append(this.dictcode).toString();
	}

    public static String buildEntityKey(Integer dictcode){
        StringBuilder build = new StringBuilder("GameDictIndex");
        return build.append(dictcode).toString();
    }
	
	public void clear(){
		this.dictcode = null;
		this.dictname = null;
		this.dftitem = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dictcode=").append(dictcode);
		sb.append(", dictname=").append(dictname);
		sb.append(", dftitem=").append(dftitem);
        sb.append("]");
        return sb.toString();
	}
}
