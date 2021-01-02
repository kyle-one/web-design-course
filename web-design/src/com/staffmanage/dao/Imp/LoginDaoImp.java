package com.staffmanage.dao.Imp;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.LoginDao;
import com.staffmanage.entity.Administrators;
import com.staffmanage.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImp implements LoginDao {

    @Override
    public Administrators getUserAndPassword(String username,String pwd) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Administrators admin = new Administrators();

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            StringBuilder sql = new StringBuilder();
            sql.append("select  *  from administrators where");
            sql.append(" username=");
            sql.append("\""+username+"\"");
            sql.append(" and pwd=");
            sql.append("\""+pwd+"\"");
            pstmt=conn.prepareStatement(sql.toString());

            rs=pstmt.executeQuery();

            while(rs.next())
            {
                admin.setUsername(rs.getString("username"));
                admin.setPwd(rs.getString("pwd"));
                admin.setSession(rs.getString("session"));
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
        return admin;
    }
}
