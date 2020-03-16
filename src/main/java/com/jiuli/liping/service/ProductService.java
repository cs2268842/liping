package com.jiuli.liping.service;

import com.jiuli.liping.vo.Message;
import com.jiuli.liping.vo.Product;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
public interface ProductService {

    public Product get(String id);

    public List<Product> findList(Product product);

    public List<Product> findAllList();

    public int insert(Product product);

    public int insertBatch(List<Product> products);

    public int update(Product product);

    public int delete(Product product);

    Message insertProduct(Product product);
}
