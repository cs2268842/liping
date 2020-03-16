package com.jiuli.liping.dao;

import com.jiuli.liping.vo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
@Component
@Mapper
public interface PictureDao {

    public Picture get(String id);

    public List<Picture> findList(Picture picture);

    public List<Picture> findAllList();

    public int insert(Picture picture);

    public int insertBatch(List<Picture> pictures);

    public int update(Picture picture);

    public int delete(Picture picture);

}