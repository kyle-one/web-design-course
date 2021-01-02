package com.staffmanage.dao.Imp;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.staffDao;
import com.staffmanage.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class updateChangeImp implements staffDao {
    @Override
    public void updateStaffDepartment(String did, String sid) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        //ResultSet rs=null;//查询结果
        List<Department> deps=new ArrayList<>();//查询结果
        int isSucceed;

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            String sql="UPDATE staff SET did=? WHERE id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,did);
            pstmt.setString(2,sid);

            isSucceed=pstmt.executeUpdate();

            //System.out.println("resule:"+isSucceed);
        } catch (SQLException e) {
            // TODO Auto-generated catch blockD
            e.printStackTrace();
        }finally
        {
            //DbUtils.closeResultSet(rs);
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
    }

    @Override
    public void updateStaffPost(String pid, String sid) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        //ResultSet rs=null;//查询结果
        List<Department> deps=new ArrayList<>();//查询结果
        int isSucceed;

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            String sql="UPDATE staff SET pid=? WHERE id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,pid);
            pstmt.setString(2,sid);

            isSucceed=pstmt.executeUpdate();

            //System.out.println("resule:"+isSucceed);
        } catch (SQLException e) {
            // TODO Auto-generated catch blockD
            e.printStackTrace();
        }finally
        {
            //DbUtils.closeResultSet(rs);
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
    }
}
