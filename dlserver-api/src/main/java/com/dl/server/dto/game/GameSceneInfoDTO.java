package com.dl.server.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameSceneInfoDTO extends BaseDTO {

	private Integer sceneid;    //场景ID
	private String scenename;    //场景名称

	public Integer getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Integer sceneid) {
		this.sceneid = sceneid;
	}

	public String getScenename() {
		return this.scenename;
	}

	public void setScenename(String scenename) {
		this.scenename = scenename;
	}


	public void clear(){
		this.sceneid = null;
		this.scenename = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", sceneid=").append(sceneid);
		sb.append(", scenename=").append(scenename);
        sb.append("]");
        return sb.toString();
	}
}
