package com.staffmanage.dao.Imp;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.postDao;
import com.staffmanage.entity.Department;
import com.staffmanage.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class postDaoImp implements postDao {
    @Override
    public List<Post> getAllPost() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Post> posts = new ArrayList<>();

        try {
            conn = DbUtils.getConnection();
            System.out.println("conn:" + conn);
            String sql = "select  *  from post";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Post post = new Post();
                post.setPnum(rs.getString("pnum"));
                post.setPname(rs.getString("pname"));
                post.setAuthorizedStrength(rs.getInt("authorizedStrength"));
                post.setType(rs.getString("type"));
                posts.add(post);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtils.closeResultSet(rs);
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
        return posts;
    }



    @Override
    public List<Post> getPostByPnumAndPnameAndType(String pnum, String pname, String type) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Post>  ps=new ArrayList<>();//查询结果

        try {
            conn= DbUtils.getConnection();
            String sql="SELECT * FROM post WHERE (del is null or del='0')";

            if (pnum!=null&&!pnum.trim().isEmpty()){//去掉空格
                sql=sql+" and pnum='"+pnum+"'";
            }
            if (pname!=null&&!pname.trim().isEmpty()){
                sql=sql+" and pname='"+pname+"'";
            }
            if (type!=null&&!type.trim().isEmpty()){
                sql=sql+" and type='"+type+"'";
            }
            System.out.println("getPostByPnumAndPnameAndType"+sql);

            pstmt=conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


            while(rs.next())
            {
                Post p=new Post();
                p.setPname(rs.getString("pname"));
                p.setPnum(rs.getString("pnum"));
                p.setType(rs.getString("type"));
                p.setAuthorizedStrength(rs.getInt("authorizedStrength"));

//                Department dep=new Department();
//                dep.setDnum(rs.getString("dnum"));
//                dep.setDname(rs.getString("dname"));
//                dep.setType(rs.getString("type"));
//                dep.setPhone(rs.getString("phone"));
//                dep.setEstablishDate(rs.getString("establishDate"));
//                dep.setDes(rs.getString("des"));
//                dep.setParent(rs.getString("parent"));
//                dep.setFax(rs.getString("fax"));
//                deps.add(dep);
                ps.add(p);
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
        return  ps;
    }

    @Override
    public void addPost(Post p) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        ResultSet rs=null;//查询结果

        try {
            //自增编号
            String sql1="select MAX(pnum+0) from post";//取
            conn= DbUtils.getConnection();//建立连接
            System.out.println("conn:"+conn);
            pstmt=conn.prepareStatement(sql1);
            rs=pstmt.executeQuery();
            int maxPnum=0;
            while(rs.next())
            {
                maxPnum=rs.getInt(1);
            }
            maxPnum+=1;
            String pnum=String.format("%04d",maxPnum);
            System.out.println(pnum);

            //String sql="select  *  from department";
            String sql="insert into post(pnum,pname,type,authorizedStrength) values(?,?,?,?)";
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,pnum);
            pstmt.setString(2,p.getPname());
            pstmt.setString(3,p.getType());
            pstmt.setString(4,String.valueOf(p.getAuthorizedStrength()));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch blockD
            e.printStackTrace();
        }finally
        {
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }

    }

    @Override
    public void deletePost(String[] pnumList) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        //ResultSet rs=null;//查询结果

        try {
            conn= DbUtils.getConnection();//建立连接
            System.out.println("conn:"+conn);
            //String sql="select  *  from department";

            for(int i=0;i<pnumList.length;i++){
                //String sql="delete from department where dnum = ?";
                String sql="update post set del=? where pnum = ?";
                System.out.println(sql);
                System.out.println(pnumList[i]);
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,"1");
                pstmt.setString(2,pnumList[i]);
                pstmt.executeUpdate();
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch blockD
            e.printStackTrace();
        }finally
        {
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
    }

    @Override
    public void updatePost(Post p) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        //ResultSet rs=null;//查询结果

        try {
            conn= DbUtils.getConnection();//建立连接
            System.out.println("conn:"+conn);
            //String sql="select  *  from department";

            String sql="update post set pname=? , type=? ,  authorizedStrength=? where pnum = ?";
            System.out.println(sql);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,p.getPname());
            pstmt.setString(2,p.getType());
            pstmt.setString(3,String.valueOf(p.getAuthorizedStrength()));
            pstmt.setString(4,p.getPnum());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch blockD
            e.printStackTrace();
        }finally
        {
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
    }

}

