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

    public boolean existId(){
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

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", menuid=").append(menuid);
		sb.append(", menuname=").append(menuname);
		sb.append(", icon=").append(icon);
		sb.append(", url=").append(url);
        sb.append("]");
        return sb.toString();
	}
}
