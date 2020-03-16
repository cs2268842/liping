package com.jiuli.liping.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Author zyl
 * Date  2020-03-13
 */
public class Userlist implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userId;
    private String wechatId="";
    private String wechatName="";
    private String userName="";
    private String userNum="";
    private String departmentDescribe="";
    private int jurisdictionId;
    private Timestamp creatTime;
    private String avatar="";
    private String thumb_avatar="";
    private String mobile="";
    private Timestamp lastTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getThumb_avatar() {
        return thumb_avatar;
    }

    public void setThumb_avatar(String thumb_avatar) {
        this.thumb_avatar = thumb_avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getLastTime() {
        return lastTime;
    }

    public void setLastTime(Timestamp lastTime) {
        this.lastTime = lastTime;
    }

    public Userlist(){
    }

    public void setUserId (int userId) {this.userId = userId;} 
    public int getUserId(){ return userId;} 
    public void setWechatId (String wechatId) {this.wechatId = wechatId;}
    public String getWechatId(){ return wechatId;}
    public void setWechatName (String wechatName) {this.wechatName = wechatName;}
    public String getWechatName(){ return wechatName;}
    public void setDepartmentDescribe (String departmentDescribe) {this.departmentDescribe = departmentDescribe;}
    public String getDepartmentDescribe(){ return departmentDescribe;}
    public void setJurisdictionId (int jurisdictionId) {this.jurisdictionId = jurisdictionId;} 
    public int getJurisdictionId(){ return jurisdictionId;} 
    public void setCreatTime (Timestamp creatTime) {this.creatTime = creatTime;}
    public Timestamp getCreatTime(){ return creatTime;}

}