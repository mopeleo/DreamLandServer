package com.dl.server.entity.game;

import com.dl.server.entity.DLEntity;

public class GameMenuInfo extends DLEntity{

	private String menuid;    //menuid
	private String menuname;    //menuname
	private String icon;    //icon
	private String url;    //url

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    public boolean hasId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameMenuInfo");
		return build.append(this.menuid).toString();
	}

    public static String buildEntityKey(String menuid){
        StringBuilder build = new StringBuilder("GameMenuInfo");
        return build.append(menuid).toString();
    }
	
	public void clear(){
		this.menuid = null;
		this.menuname = null;
		this.icon = null;
		this.url = null;
	}
}
