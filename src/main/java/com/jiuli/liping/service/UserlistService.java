package com.jiuli.liping.service;

import com.jiuli.liping.vo.Userlist;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-13
 */
public interface UserlistService {

    public Userlist get(String id);

    public List<Userlist> findList(Userlist userlist);

    public List<Userlist> findAllList();

    public int insert(Userlist userlist);

    public int insertBatch(List<Userlist> userlists);

    public int update(Userlist userlist);

    public int delete(Userlist userlist);

    int getCount(Userlist ul);

    List<Userlist> getDepartMentByHR(String position);
}
