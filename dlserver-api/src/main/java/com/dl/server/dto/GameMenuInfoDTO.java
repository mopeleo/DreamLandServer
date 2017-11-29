package com.dl.server.dto;

public class GameMenuInfoDTO extends BaseDTO {

	public int menuid;    //menuid
	public int menuname;    //menuname
	public int icon;    //icon
	public int url;    //url

	public int getMenuid() {
		return this.menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getMenuname() {
		return this.menuname;
	}

	public void setMenuname(int menuname) {
		this.menuname = menuname;
	}

	public int getIcon() {
		return this.icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getUrl() {
		return this.url;
	}

	public void setUrl(int url) {
		this.url = url;
	}

}
