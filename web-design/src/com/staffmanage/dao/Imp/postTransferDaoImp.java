package com.staffmanage.dao.Imp;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.departmentTransferDao;
import com.staffmanage.dao.postTransferDao;
import com.staffmanage.entity.DepartmentTransfer;
import com.staffmanage.entity.PostTransfer;
import com.staffmanage.entity.view.DepartmentTransferView;
import com.staffmanage.entity.view.PostTransferView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class postTransferDaoImp implements postTransferDao {
    @Override
    public void add(PostTransfer postTransfer) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        System.out.println("sid="+postTransfer.getSid());
        System.out.println("pid1="+postTransfer.getPid1());
        System.out.println("pid2="+postTransfer.getPid2());
        System.out.println("tdate="+postTransfer.getTdate());
        System.out.println("reason="+postTransfer.getReason());
        System.out.println("remarks="+postTransfer.getRemarks());
        System.out.println("type="+postTransfer.getType());
        try {
            conn = DbUtils.getConnection();
            String sql = "insert into posttransfer(sid,pid1,pid2,tdate,reason,remarks,type,pf) values(?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,postTransfer.getSid());
            pstmt.setString(2,postTransfer.getPid1());
            pstmt.setString(3,postTransfer.getPid2());
            pstmt.setString(4,postTransfer.getTdate());
            pstmt.setString(5,postTransfer.getReason());
            pstmt.setString(6,postTransfer.getRemarks());
            pstmt.setString(7,postTransfer.getType());
            pstmt.setInt(8, postTransfer.getPf());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
    }

    @Override
    public List<PostTransfer> getAll() {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        ResultSet rs=null;//查询结果
        List<PostTransfer> dtlist=new ArrayList<>();//查询结果

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            String sql="select  *  from posttransferview where del is 0";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();


            while(rs.next())
            {
                DepartmentTransfer dt=new DepartmentTransfer();
                dt.setSid(rs.getString("sid"));
                dt.setDid1(rs.getString("did1"));
                dt.setDid2(rs.getString("did2"));
                dt.setTdate(rs.getString("tdate"));
                dt.setReason(rs.getString("reason"));
                dt.setRemarks(rs.getString("remarks"));
                dt.setType(rs.getString("type"));
//                dtlist.add(dt);
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
        return  dtlist;
    }

    @Override
    public List<PostTransferView> getByTimeAndSidAndSnameAndType(String startime, String endtime, String sid, String sname, String type) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        ResultSet rs=null;//查询结果
        List<PostTransferView> dtlist=new ArrayList<>();//查询结果

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            String sql="select  *  from posttransferview where pf=0 ";
            if (startime!=null&&!startime.trim().isEmpty()){
                sql=sql+" and tdate>"+"\""+startime+"\"";
            }
            if (endtime!=null&&!endtime.trim().isEmpty()){
                sql=sql+" and tdate<"+"\""+endtime+"\"";
            }
            if (sid!=null&&!sid.trim().isEmpty()){
                sql=sql+" and sid="+sid;
            }
            if (sname!=null&&!sname.trim().isEmpty()){
                sql=sql+" and name="+"\""+sname+"\"";
                System.out.println(sql);
            }
            if (type!=null&&!type.trim().isEmpty()){
                sql=sql+" and type="+type;
            }
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();


            while(rs.next())
            {
                PostTransferView pt=new PostTransferView();
                pt.setSid(rs.getString("sid"));
                pt.setPid1(rs.getString("pid1"));
                pt.setPid2(rs.getString("pid2"));
                pt.setTdate(rs.getString("tdate"));
                pt.setReason(rs.getString("reason"));
                pt.setRemarks(rs.getString("remarks"));
                pt.setType(rs.getString("type"));
                //dt.setDname(rs.getString("dname"));
                pt.setName(rs.getString("name"));
                pt.setPostname(rs.getString("postname"));
                dtlist.add(pt);
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
        return  dtlist;
    }
}
