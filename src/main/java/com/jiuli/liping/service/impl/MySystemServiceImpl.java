package com.jiuli.liping.service.impl;

import com.jiuli.liping.dao.MySystemDao;
import com.jiuli.liping.vo.MySystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jiuli.liping.service.MySystemService;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@Service
public class MySystemServiceImpl implements MySystemService {
    @Autowired
    private MySystemDao mySystemDao;
    
    @Override
    public MySystem get(String id){
        return mySystemDao.get(id);
    }
    
    @Override
    public List<MySystem> findList(MySystem mySystem) {
        return mySystemDao.findList(mySystem);
    }
    
    @Override
    public List<MySystem> findAllList() {
        return mySystemDao.findAllList();
    }
    
    @Override
    public int insert(MySystem mySystem) {
        return mySystemDao.insert(mySystem);
    }
    
    @Override
    public int insertBatch(List<MySystem> mySystems){
        return mySystemDao.insertBatch(mySystems);
    }
    
    @Override
    public int update(MySystem mySystem) {
        return mySystemDao.update(mySystem);
    }
    
    @Override
    public int delete(MySystem mySystem) {
        return mySystemDao.delete(mySystem);
    }

    @Override
    public List<MySystem> getProductList() {
        return mySystemDao.getProductList();
    }

}
