package com.staffmanage.dao.Imp;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.departmentTransferDao;
import com.staffmanage.entity.DepartmentTransfer;
import com.staffmanage.entity.view.DepartmentTransferView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class departmentTransferDaoImp implements departmentTransferDao {
    @Override
    public void add(DepartmentTransfer departmentTransfer) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        System.out.println("sid="+departmentTransfer.getSid());
        System.out.println("did1="+departmentTransfer.getDid1());
        System.out.println("did2="+departmentTransfer.getDid2());
        System.out.println("tdate="+departmentTransfer.getTdate());
        System.out.println("reason="+departmentTransfer.getReason());
        System.out.println("remarks="+departmentTransfer.getRemarks());
        System.out.println("type="+departmentTransfer.getType());
        try {
            conn = DbUtils.getConnection();
            String sql = "insert into departmenttransfer(sid,did1,did2,tdate,reason,remarks,type,pf) values(?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,departmentTransfer.getSid());
            pstmt.setString(2,departmentTransfer.getDid1());
            pstmt.setString(3,departmentTransfer.getDid2());
            pstmt.setString(4,departmentTransfer.getTdate());
            pstmt.setString(5,departmentTransfer.getReason());
            pstmt.setString(6,departmentTransfer.getRemarks());
            pstmt.setString(7,departmentTransfer.getType());
            pstmt.setInt(8, departmentTransfer.getPf());

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
    public List<DepartmentTransfer> getAll() {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        ResultSet rs=null;//查询结果
        List<DepartmentTransfer> dtlist=new ArrayList<>();//查询结果

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            String sql="select  *  from departmenttransfer where del is 0";
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
                dtlist.add(dt);
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
    public List<DepartmentTransferView> getByTimeAndSidAndSnameAndType(String startime, String endtime, String sid, String sname, String type) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        ResultSet rs=null;//查询结果
        List<DepartmentTransferView> dtlist=new ArrayList<>();//查询结果

        try {
            conn= DbUtils.getConnection();
            System.out.println("conn:"+conn);
            String sql="select  *  from departmenttransferview where pf=0 ";
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
                DepartmentTransferView dt=new DepartmentTransferView();
                dt.setSid(rs.getString("sid"));
                dt.setDid1(rs.getString("did1"));
                dt.setDid2(rs.getString("did2"));
                dt.setTdate(rs.getString("tdate"));
                dt.setReason(rs.getString("reason"));
                dt.setRemarks(rs.getString("remarks"));
                dt.setType(rs.getString("type"));
                //dt.setDname(rs.getString("dname"));
                dt.setName(rs.getString("name"));
                dt.setTypename(rs.getString("typename"));
                dtlist.add(dt);
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
