package com.jiuli.liping.dao;

import com.jiuli.liping.vo.Userlist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author zyl
 * Date  2020-03-13
 */
@Component
@Mapper
public interface UserlistDao {

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