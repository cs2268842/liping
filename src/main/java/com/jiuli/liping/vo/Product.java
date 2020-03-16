package com.jiuli.liping.vo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Author zyl
 * Date  2020-03-14
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private String tradeName="";
    private String amount="";
    private String picture="";
    private String describe="";
    private String purchasePrice="";
    private String marketPrice="";
    private String supplier="";
    private Timestamp createTime;
    private String createUser="";
    private String goodsState="";
    private String productCategoryId="";
    private String productHeat="";
    private String commodityExhibitionId="";
    private String productNum="";
    private String fbk3="";
    private String fbk4="";
    private String fbk5="";
    private String fbk1="";

    private MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public Product(){
    }

    public void setProductId (int productId) {this.productId = productId;} 
    public int getProductId(){ return productId;} 
    public void setTradeName (String tradeName) {this.tradeName = tradeName;}
    public String getTradeName(){ return tradeName;}
    public void setAmount (String amount) {this.amount = amount;}
    public String getAmount(){ return amount;}
    public void setPicture (String picture) {this.picture = picture;}
    public String getPicture(){ return picture;}
    public void setDescribe (String describe) {this.describe = describe;}
    public String getDescribe(){ return describe;}
    public void setPurchasePrice (String purchasePrice) {this.purchasePrice = purchasePrice;}
    public String getPurchasePrice(){ return purchasePrice;}
    public void setMarketPrice (String marketPrice) {this.marketPrice = marketPrice;}
    public String getMarketPrice(){ return marketPrice;}
    public void setSupplier (String supplier) {this.supplier = supplier;}
    public String getSupplier(){ return supplier;}
    public void setCreateTime (Timestamp createTime) {this.createTime = createTime;}
    public Timestamp getCreateTime(){ return createTime;}
    public void setCreateUser (String createUser) {this.createUser = createUser;}
    public String getCreateUser(){ return createUser;}
    public void setGoodsState (String goodsState) {this.goodsState = goodsState;}
    public String getGoodsState(){ return goodsState;}
    public void setProductCategoryId (String productCategoryId) {this.productCategoryId = productCategoryId;}
    public String getProductCategoryId(){ return productCategoryId;}
    public void setProductHeat (String productHeat) {this.productHeat = productHeat;}
    public String getProductHeat(){ return productHeat;}
    public void setCommodityExhibitionId (String commodityExhibitionId) {this.commodityExhibitionId = commodityExhibitionId;}
    public String getCommodityExhibitionId(){ return commodityExhibitionId;}
    public void setProductNum (String productNum) {this.productNum = productNum;}
    public String getProductNum(){ return productNum;}
    public void setFbk3 (String fbk3) {this.fbk3 = fbk3;}
    public String getFbk3(){ return fbk3;}
    public void setFbk4 (String fbk4) {this.fbk4 = fbk4;}
    public String getFbk4(){ return fbk4;}
    public void setFbk5 (String fbk5) {this.fbk5 = fbk5;}
    public String getFbk5(){ return fbk5;}
    public void setFbk1 (String fbk1) {this.fbk1 = fbk1;}
    public String getFbk1(){ return fbk1;}

}