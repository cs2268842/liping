package com.jiuli.liping.dao;

import com.jiuli.liping.vo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@Component
@Mapper
public interface ProductDao {

    public Product get(String id);

    public List<Product> findList(Product product);

    public List<Product> findAllList();

    public int insert(Product product);

    public int insertBatch(List<Product> products);

    public int update(Product product);

    public int delete(Product product);

    Product getByName(Product product);

    int getByProjectName(Product product);
}