package com.dl.base.utils;

public class UserDTO {

    private String action;
    private String username;
    private double age;
    private String retcode;
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public double getAge() {
        return age;
    }
    public void setAge(double age) {
        this.age = age;
    }
    public String getRetcode() {
        return retcode;
    }
    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }
    @Override
    public String toString(){
        return "UserEntity # action : " + this.action + ", username : " + this.username + 
                ", age : " + this.age + ", retcode : " + this.retcode;
    }
    
}
