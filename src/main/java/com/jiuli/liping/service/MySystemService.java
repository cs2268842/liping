package com.jiuli.liping.service;

import com.jiuli.liping.vo.MySystem;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
public interface MySystemService {

    public MySystem get(String id);

    public List<MySystem> findList(MySystem mySystem);

    public List<MySystem> findAllList();

    public int insert(MySystem mySystem);

    public int insertBatch(List<MySystem> mySystems);

    public int update(MySystem mySystem);

    public int delete(MySystem mySystem);

    List<MySystem> getProductList();
}
