package com.jiuli.liping.dao;

import com.jiuli.liping.vo.MySystem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@Component
@Mapper
public interface MySystemDao {

    public MySystem get(String id);

    public List<MySystem> findList(MySystem mySystem);

    public List<MySystem> findAllList();

    public int insert(MySystem mySystem);

    public int insertBatch(List<MySystem> mySystems);

    public int update(MySystem mySystem);

    public int delete(MySystem mySystem);

    List<MySystem> getProductList();
}