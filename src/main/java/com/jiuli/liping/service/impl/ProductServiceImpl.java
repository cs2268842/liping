package com.jiuli.liping.service.impl;

import com.jiuli.liping.dao.ProductDao;
import com.jiuli.liping.vo.Message;
import com.jiuli.liping.vo.Picture;
import com.jiuli.liping.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jiuli.liping.service.ProductService;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private FileManageServiceImpl fileManageServiceImpl;
    
    @Override
    public Product get(String id){
        return productDao.get(id);
    }
    
    @Override
    public List<Product> findList(Product product) {
        return productDao.findList(product);
    }
    
    @Override
    public List<Product> findAllList() {
        return productDao.findAllList();
    }
    
    @Override
    public int insert(Product product) {
        return productDao.insert(product);
    }
    
    @Override
    public int insertBatch(List<Product> products){
        return productDao.insertBatch(products);
    }
    
    @Override
    public int update(Product product) {
        return productDao.update(product);
    }
    
    @Override
    public int delete(Product product) {
        return productDao.delete(product);
    }

    @Override
    @Transactional
    public Message insertProduct(Product product) {
        Message mess = new Message();
        int b = productDao.getByProjectName(product);
        if(b>=1){
            mess.setFlag("0");
            mess.setMessage("商品名字重复");
            return mess;
        }

        //保存商品基本信息
        String str = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        //System.out.println(str);
        product.setProductNum(str);
        int a = productDao.insert(product);
        if(a==1){
            //上传文件
            Product newpro = productDao.getByName(product);
            product.setProductId(newpro.getProductId());//找到唯一id
            fileManageServiceImpl.uploadFiles(product);
            mess.setFlag("1");
            mess.setMessage("商品发布成功");
        }
        return mess;
    }

}
