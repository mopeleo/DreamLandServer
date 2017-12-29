package com.dl.server.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultDTO<T extends BaseDTO> implements Serializable{

    private boolean success = true;
    private String retcode = "0000";
    private String retmsg = "success";
    private List<T> results;

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
    
    public void addResult(T result){
        if(this.results == null){
            this.results = new ArrayList<T>();
        }
        
        this.results.add(result);
    }
    
    public T getResult(){
        return this.getResult(0);
    }
    
    public T getResult(int index){
        if(this.results == null){
            return null;
        }
        
        return this.results.get(index);
    }
    
    public int getSize(){
        if(this.results == null){
            return 0;
        }
        
        return this.results.size();
    }
}
