package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameMenuInfoDTO extends BaseDTO {

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

}
