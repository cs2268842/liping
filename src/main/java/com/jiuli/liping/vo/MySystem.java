package com.jiuli.liping.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
public class MySystem implements Serializable {
    private static final long serialVersionUID = 1L;
    private int sysId;
    private String oneNum;
    private String oneName;
    private String twoNum;
    private String twoName;
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public MySystem(){
    }

    public void setSysId (int sysId) {this.sysId = sysId;} 
    public int getSysId(){ return sysId;} 
    public void setOneNum (String oneNum) {this.oneNum = oneNum;}
    public String getOneNum(){ return oneNum;}
    public void setOneName (String oneName) {this.oneName = oneName;}
    public String getOneName(){ return oneName;}
    public void setTwoNum (String twoNum) {this.twoNum = twoNum;}
    public String getTwoNum(){ return twoNum;}
    public void setTwoName (String twoName) {this.twoName = twoName;}
    public String getTwoName(){ return twoName;}

}