package com.jiuli.liping.service.impl;

import com.jiuli.liping.dao.UserlistDao;
import com.jiuli.liping.vo.Userlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jiuli.liping.service.UserlistService;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-13
 */
@Service
public class UserlistServiceImpl implements UserlistService {
    @Autowired
    private UserlistDao userlistDao;
    
    @Override
    public Userlist get(String id){
        return userlistDao.get(id);
    }
    
    @Override
    public List<Userlist> findList(Userlist userlist) {
        return userlistDao.findList(userlist);
    }
    
    @Override
    public List<Userlist> findAllList() {
        return userlistDao.findAllList();
    }
    
    @Override
    public int insert(Userlist userlist) {
        return userlistDao.insert(userlist);
    }
    
    @Override
    public int insertBatch(List<Userlist> userlists){
        return userlistDao.insertBatch(userlists);
    }
    
    @Override
    public int update(Userlist userlist) {
        return userlistDao.update(userlist);
    }
    
    @Override
    public int delete(Userlist userlist) {
        return userlistDao.delete(userlist);
    }

    @Override
    public int getCount(Userlist ul) {
        return userlistDao.getCount(ul);
    }

    @Override
    public List<Userlist> getDepartMentByHR(String position) {
        return userlistDao.getDepartMentByHR(position);
    }

}
