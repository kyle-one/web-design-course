package com.staffmanage.dao;

import com.staffmanage.entity.Department;
import com.staffmanage.entity.Post;

import java.util.List;

public interface postDao {
    //获得所有岗位
    List<Post> getAllPost();
    //通过xx获取
    List<Post> getPostByPnumAndPnameAndType(String pnum,String pname,String type);
    //添加部门
    void addPost(Post p);
    //删除部门
    void deletePost(String[] pnumList);
    //更新部门
    void updatePost(Post p);



}
