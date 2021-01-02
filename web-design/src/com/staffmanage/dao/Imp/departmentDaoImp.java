package com.staffmanage.dao.Imp;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.departmentDao;
import com.staffmanage.entity.Department;
import com.staffmanage.entity.view.changeDepartmentView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class departmentDaoImp implements departmentDao {

    @Override
    public void addDepartment(Department dep) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        ResultSet rs=null;//查询结果

        try {
            //自增编号
            String sql1="select MAX(dnum+0) from department";//取
            conn= DbUtils.getConnection();//建立连接
            System.out.println("conn:"+conn);
            pstmt=conn.prepareStatement(sql1);
            rs=pstmt.executeQuery();
            int maxDnum=0;
            while(rs.next())
            {
                maxDnum=rs.getInt(1);
            }
            maxDnum+=1;
            String dnum=String.format("%04d",maxDnum);
            System.out.println(dnum);





            //String sql="select  *  from department";
            String sql="insert into department(dnum,dname,type,phone,des,parent,establishDate,fax) values(?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,dnum);
            pstmt.setString(2,dep.getDname());
            pstmt.setString(3,dep.getType());
            pstmt.setString(4,dep.getPhone());
            pstmt.setString(5,dep.getDes());
            pstmt.setString(6,dep.getParent());
            pstmt.setString(7,dep.getEstablishDate());
            pstmt.setString(8,dep.getFax());
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
    public void queryDepartment(Department dep) {

    }

    @Override
    public void deleteDepartment(String[] dnumList) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        //ResultSet rs=null;//查询结果

        try {
            conn= DbUtils.getConnection();//建立连接
            System.out.println("conn:"+conn);
            //String sql="select  *  from department";
            for(int i=0;i<dnumList.length;i++){
                //String sql="delete from department where dnum = ?";
                String sql="update department set del=? where dnum = ?";
                System.out.println(sql);
                System.out.println(dnumList[i]);
                //String sql="insert into department(dnum,dname,type,phone,des,parent,establishDate,fax) values(?,?,?,?,?,?,?,?)";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,"1");
                pstmt.setString(2,dnumList[i]);
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
    public List<Department> getByDnumAndDnameAndType(String dnum, String dname, String type){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Department>  deps=new ArrayList<>();//查询结果

        try {
            conn= DbUtils.getConnection();
            String sql="SELECT * FROM department WHERE (del is null or del='0')";

            if (dnum!=null&&!dnum.trim().isEmpty()){//去掉空格
                sql=sql+" and dnum='"+dnum+"'";
            }
            if (dname!=null&&!dname.trim().isEmpty()){
                sql=sql+" and dname='"+dname+"'";
            }
            if (type!=null&&!type.trim().isEmpty()){
                sql=sql+" and type='"+type+"'";
            }
            System.out.println(sql);

            pstmt=conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


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
    public void updateDepartment(Department dep) {
        Connection conn=null;//建立连接
        PreparedStatement pstmt=null;//查询
        //ResultSet rs=null;//查询结果

        try {
            conn= DbUtils.getConnection();//建立连接
            System.out.println("conn:"+conn);
            //String sql="select  *  from department";

            String sql="update department set dname=? , type=? , phone=? , des=? , parent=? , establishDate=? , fax=? where dnum = ?";
            System.out.println(sql);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,dep.getDname());
            pstmt.setString(2,dep.getType());
            pstmt.setString(3,dep.getPhone());
            pstmt.setString(4,dep.getDes());
            pstmt.setString(5,dep.getParent());
            pstmt.setString(6,dep.getEstablishDate());
            pstmt.setString(7,dep.getFax());
            pstmt.setString(8,dep.getDnum());

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
