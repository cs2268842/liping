package com.jiuli.liping.service;

import com.jiuli.liping.vo.Picture;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-14
 */
public interface PictureService {

    public Picture get(String id);

    public List<Picture> findList(Picture picture);

    public List<Picture> findAllList();

    public int insert(Picture picture);

    public int insertBatch(List<Picture> pictures);

    public int update(Picture picture);

    public int delete(Picture picture);

}
