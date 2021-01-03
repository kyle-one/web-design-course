package com.staffmanage.dao.Imp;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.departmentDao;
import com.staffmanage.dao.postDao;
import com.staffmanage.dao.changeDepartmentDao;
import com.staffmanage.entity.Department;
import com.staffmanage.entity.Post;
import com.staffmanage.entity.Staff;
import com.staffmanage.entity.view.changeDepartmentView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class changeDepartmentImp implements changeDepartmentDao, departmentDao, postDao {

    @Override
    public void getByID(int id) {

    }

    @Override
    public List<Staff> getByDidAndDnameAndSidAndSname() {
        return null;
    }

    @Override
    public List<Staff> getAllStaff() {
        return null;
    }

    @Override
    public List<changeDepartmentView> getByDidAndDnameAndSidAndSname(String did, String dname, String sid, String sname) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet resultSet=null;
        List<changeDepartmentView> cdvArrayList = new ArrayList<>();

        try {
            conn= DbUtils.getConnection();
            String sql="SELECT * FROM staff,department,post WHERE staff.did=department.dnum and staff.pid=post.pnum";
            int i=1;
            if (did!=null&&!did.trim().isEmpty()){
                sql=sql+" and did="+did;
            }
            if (dname!=null&&!dname.trim().isEmpty()){
                sql=sql+" and dname='"+dname+"'";
            }
            if (sid!=null&&!sid.trim().isEmpty()){
                sql=sql+" and id="+sid;
            }
            if (sname!=null&&!sname.trim().isEmpty()){
                sql=sql+" and name='"+sname+"'";
            }

            pstmt=conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                changeDepartmentView view = new changeDepartmentView();
                view.setId(resultSet.getString("id"));
                view.setName(resultSet.getString("name"));
                view.setDid(resultSet.getString("did"));
                view.setPid(resultSet.getString("pid"));
                view.setDname(resultSet.getString("dname"));
                view.setPname(resultSet.getString("pname"));
                cdvArrayList.add(view);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally
        {
            DbUtils.closeStatement(pstmt);
            DbUtils.closeResultSet(resultSet);
            DbUtils.closeConnection();
        }
        return cdvArrayList;
    }

    @Override
    public void addDepartment(Department dep) {

    }

    @Override
    public void queryDepartment(Department dep) {

    }

    @Override
    public void deleteDepartment(String[] dnumList) {

    }

    @Override
    public List<Department> getAllDepartment() {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        ResultSet rs=null;//查询结果
        List<Department>  deps=new ArrayList<>();//查询结果

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            String sql="select  *  from department where del is null";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();


            while(rs.next())
            {
                Department dep=new Department();
                dep.setDnum(rs.getString("dnum"));
                dep.setDname(rs.getString("dname"));
                dep.setType(rs.getString("type"));
                dep.setPhone(rs.getString("phone"));
                dep.setEstablishDate(rs.getString("establishDate"));
                dep.setDes(rs.getString("des"));
                dep.setParent(rs.getString("parent"));
                dep.setFax(rs.getString("fax"));
                deps.add(dep);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch blockD
            e.printStackTrace();
        }finally
        {
            DbUtils.closeResultSet(rs);
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
        return  deps;
    }

    @Override
    public List<Department> getByDnumAndDnameAndType(String dnum, String dname, String type) {
        return null;
    }

    @Override
    public void updateDepartment(Department dep) {

    }

    @Override
    public List<Post> getAllPost() {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Post> posts=new ArrayList<>();

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            String sql="select  *  from post";
            pstmt=conn.prepareStatement(sql);

            rs=pstmt.executeQuery();

            while(rs.next())
            {
                Post post=new Post();
                post.setPnum(rs.getString("pnum"));
                post.setPname(rs.getString("pname"));
                post.setAuthorizedStrength(rs.getInt("authorizedStrength"));
                post.setType(rs.getString("type"));
                posts.add(post);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally
        {
            DbUtils.closeResultSet(rs);
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
        return  posts;
    }

    @Override
    public List<Post> getPostByPnumAndPnameAndType(String pnum, String pname, String type) {
        return null;
    }

    @Override
    public void addPost(Post p) {

    }

    @Override
    public void deletePost(String[] pnumList) {

    }

    @Override
    public void updatePost(Post p) {

    }


}
