package com.jiuli.liping.service.impl;

import com.jiuli.liping.dao.PictureDao;
import com.jiuli.liping.vo.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jiuli.liping.service.PictureService;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;
    
    @Override
    public Picture get(String id){
        return pictureDao.get(id);
    }
    
    @Override
    public List<Picture> findList(Picture picture) {
        return pictureDao.findList(picture);
    }
    
    @Override
    public List<Picture> findAllList() {
        return pictureDao.findAllList();
    }
    
    @Override
    public int insert(Picture picture) {
        return pictureDao.insert(picture);
    }
    
    @Override
    public int insertBatch(List<Picture> pictures){
        return pictureDao.insertBatch(pictures);
    }
    
    @Override
    public int update(Picture picture) {
        return pictureDao.update(picture);
    }
    
    @Override
    public int delete(Picture picture) {
        return pictureDao.delete(picture);
    }

}
