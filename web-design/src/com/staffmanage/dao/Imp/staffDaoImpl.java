package com.staffmanage.dao.Imp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.staffDao1;
import com.staffmanage.entity.Staff;
import com.staffmanage.entity.Staff1;


public class staffDaoImpl implements staffDao1 {


    @Override
    public void addstaff(Staff1 s) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        try {
            conn = DbUtils.getConnection();
            String sql1="select MAX(id+0) from staff";
            pstmt=conn.prepareStatement(sql1);
            rs=pstmt.executeQuery();
            int maxid=0;
            while (rs.next())
                maxid=rs.getInt(1);
            maxid=maxid+1;
            System.out.println(maxid);
            String id=String.format("%08d",maxid);
            System.out.println(id);
            System.out.println("1111");
            String sql = "insert into staff(id,sex,birthDate,idcardNo,formOfEmployment,sourceOfStaff,politicCountenance," +
                    "nation,nativePlace,phone,email,height,name,maritalStatus, birthPlace,Hukou, highestEducation," +
                    "highestDegree,university,majors,dateOfGraduation,entryDate,workDate,bloodType,pid,did) values(?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, s.getSex());
            pstmt.setString(3, s.getBirthDate());
            pstmt.setString(4, s.getIdcardNo());
            pstmt.setString(5, s.getFormOfEmployment());
            pstmt.setString(6, s.getSourceOfStaff());
            pstmt.setString(7, s.getPoliticCountenance());
            pstmt.setString(8, s.getNation());
            pstmt.setString(9, s.getNativePlace());
            pstmt.setString(10, s.getPhone());
            pstmt.setString(11, s.getEmail());
            pstmt.setString(12, s.getHeight());
            pstmt.setString(13, s.getName());
            pstmt.setString(14, s.getMaritalStatus());
            pstmt.setString(15, s.getBirthPlace());
            pstmt.setString(16, s.getHukou());
            pstmt.setString(17, s.getHighestEducation());
            pstmt.setString(18, s.getHighestDegree());
            pstmt.setString(19, s.getUniversity());
            pstmt.setString(20, s.getMajors());
            pstmt.setString(21, s.getDateOfGraduation());
            pstmt.setString(22, s.getEntryDate());
            pstmt.setString(23, s.getWorkDate());
            pstmt.setString(24, s.getBloodType());
            pstmt.setString(25, s.getPid());
            pstmt.setString(26, s.getDid());

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
    public void delete(String id) {
// TODO Auto-generated method stub
        Connection  conn=null;
        PreparedStatement  pstmt=null;

        try {
            conn= DbUtils.getConnection();
            String sql="update staff set del='1' where id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally
        {
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
    }

//    @Override
//    public List<staff> getAllstaff() {
//        // TODO Auto-generated method stub
//        Connection  conn=null;
//        PreparedStatement  pstmt=null;
//        ResultSet  rs=null;
//        List<staff>  s=new ArrayList<>();
//
//        try {
//            conn=DbUtils.getConnection();
//            System.out.println("conn:"+conn);
//            String sql="select  *  from student";
//            pstmt=conn.prepareStatement(sql);
//
//            rs=pstmt.executeQuery();
//
//            while(rs.next())
//            {
//                staff  s1=new staff();
//                s1.setId(rs.getString("id"));
//                s1.setSex(rs.getString("sex"));
//                s1.setBirthDate(rs.getString("birthDate"));
//                s1.setIdcardNo(rs.getString("idcardNo"));
//                s1.setSourceOfStaff(rs.getString("sourceOfStaff"));
//                s1.setPoliticCountenance(rs.getString("politicCountenance"));
//                s1.setFormOfEmployment(rs.getString("formOfEmployment"));
//                s1.setNation(rs.getString("nation"));
//                s1.setNativePlace(rs.getString("nativePlace"));
//                s1.setPhone(rs.getString("phone"));
//                s1.setEmail(rs.getString("email"));
//                s1.setHeight(rs.getInt("height"));
//                s1.setName(rs.getString("name"));
//                s1.setMaritalStatus(rs.getString("maritalStatus"));
//                s1.setBirthPlace(rs.getString("birthPlace"));
//                s1.setHukou(rs.getString("Hukou"));
//                s1.setHighestEducation(rs.getString("highestEducation"));
//                s1.setHighestDegree(rs.getString("highestDegree"));
//                s1.setUniversity(rs.getString("university"));
//                s1.setMajors(rs.getString("majors"));
//                s1.setDateOfGraduation(rs.getString("dateOfGraduation"));
//                s1.setEntryDate(rs.getString("entryDate"));
//                s1.setWorkDate(rs.getString("workDate"));
//                s1.setBloodType(rs.getString("bloodType"));
//                s1.setPid(rs.getString("pid"));
//                s1.setDid(rs.getString("did"));
//                s.add(s1);
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }finally
//        {
//            DbUtils.closeResultSet(rs);
//            DbUtils.closeStatement(pstmt);
//            DbUtils.closeConnection();
//        }
//        return  s;
//    }

    @Override
    public List<Staff1> getstaffByPDIN(String did, String dname, String id, String name) {
        Connection  conn=null;
        PreparedStatement  pstmt=null;
        ResultSet  rs=null;
        List<Staff1>  s=new ArrayList<Staff1>();
        try {
            conn=DbUtils.getConnection();
            System.out.println("conn:"+conn);

            System.out.println(did);
            System.out.println(dname);
            System.out.println(id);
            System.out.println(name);
            String sql="select  *  from staff where 1=1 and (del is null or del='0')";
            int i=1;
            if (did!=null&&!did.trim().isEmpty()){
                sql=sql+" and did=? ";

            }
            if (id!=null&&!id.trim().isEmpty()){
                sql=sql+" and id=? ";

            }
            if (name!=null&&!name.trim().isEmpty()){
                sql=sql+" and name=? ";

            }
            if (dname!=null&&!dname.trim().isEmpty()){
                sql=sql+" and did=(select dnum from department where dname=?) ";

            }
            pstmt=conn.prepareStatement(sql);
            if (did!=null&&!did.trim().isEmpty())
                pstmt.setString(i++, did);
            if (id!=null&&!id.trim().isEmpty())
                pstmt.setString(i++, id);
            if (name!=null&&!name.trim().isEmpty())
                pstmt.setString(i++, name);
            if (dname!=null&&!dname.trim().isEmpty())
                pstmt.setString(i++, dname);
            System.out.println(sql);

            rs=pstmt.executeQuery();
            while(rs.next())
            {
                Staff1  s1=new Staff1();
                s1.setId(rs.getString("id"));
                s1.setSex(rs.getString("sex"));
                s1.setBirthDate(rs.getString("birthDate"));
                s1.setIdcardNo(rs.getString("idcardNo"));
                s1.setSourceOfStaff(rs.getString("sourceOfStaff"));
                s1.setPoliticCountenance(rs.getString("politicCountenance"));
                s1.setFormOfEmployment(rs.getString("formOfEmployment"));
                s1.setNation(rs.getString("nation"));
                s1.setNativePlace(rs.getString("nativePlace"));
                s1.setPhone(rs.getString("phone"));
                s1.setEmail(rs.getString("email"));
                s1.setHeight(rs.getString("height"));
                s1.setName(rs.getString("name"));
                s1.setMaritalStatus(rs.getString("maritalStatus"));
                s1.setBirthPlace(rs.getString("birthPlace"));
                s1.setHukou(rs.getString("Hukou"));
                s1.setHighestEducation(rs.getString("highestEducation"));
                s1.setHighestDegree(rs.getString("highestDegree"));
                s1.setUniversity(rs.getString("university"));
                s1.setMajors(rs.getString("majors"));
                s1.setDateOfGraduation(rs.getString("dateOfGraduation"));
                s1.setEntryDate(rs.getString("entryDate"));
                s1.setWorkDate(rs.getString("workDate"));
                s1.setBloodType(rs.getString("bloodType"));
                s1.setPid(rs.getString("pid"));
                s1.setDid(rs.getString("did"));
                s.add(s1);
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
        return s;
    }

    @Override
    public List<Staff1> getstaffByPostNUm(String pnum) {
        Connection  conn=null;
        PreparedStatement  pstmt=null;
        ResultSet  rs=null;
        List<Staff1>  s=new ArrayList<Staff1>();
        try {
            conn=DbUtils.getConnection();
            System.out.println("conn:"+conn);

            String sql="select  *  from staff where 1=1 and (del is null or del='0')";

            if (pnum!=null&&!pnum.trim().isEmpty()){
                sql=sql+" and pid=? ";
            }

            pstmt=conn.prepareStatement(sql);
            if (pnum!=null&&!pnum.trim().isEmpty())
                pstmt.setString(1, pnum);
            System.out.println(sql+pnum);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                Staff1  s1=new Staff1();
                s1.setId(rs.getString("id"));
                s1.setSex(rs.getString("sex"));
                s1.setBirthDate(rs.getString("birthDate"));
                s1.setIdcardNo(rs.getString("idcardNo"));
                s1.setSourceOfStaff(rs.getString("sourceOfStaff"));
                s1.setPoliticCountenance(rs.getString("politicCountenance"));
                s1.setFormOfEmployment(rs.getString("formOfEmployment"));
                s1.setNation(rs.getString("nation"));
                s1.setNativePlace(rs.getString("nativePlace"));
                s1.setPhone(rs.getString("phone"));
                s1.setEmail(rs.getString("email"));
                s1.setHeight(rs.getString("height"));
                s1.setName(rs.getString("name"));
                s1.setMaritalStatus(rs.getString("maritalStatus"));
                s1.setBirthPlace(rs.getString("birthPlace"));
                s1.setHukou(rs.getString("Hukou"));
                s1.setHighestEducation(rs.getString("highestEducation"));
                s1.setHighestDegree(rs.getString("highestDegree"));
                s1.setUniversity(rs.getString("university"));
                s1.setMajors(rs.getString("majors"));
                s1.setDateOfGraduation(rs.getString("dateOfGraduation"));
                s1.setEntryDate(rs.getString("entryDate"));
                s1.setWorkDate(rs.getString("workDate"));
                s1.setBloodType(rs.getString("bloodType"));
                s1.setPid(rs.getString("pid"));
                s1.setDid(rs.getString("did"));
                s.add(s1);
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
        return s;
    }

    @Override
    public void update(Staff1 s) {
        Connection  conn=null;
            PreparedStatement  pstmt=null;

            try {
                conn= DbUtils.getConnection();
                String sql="update staff set del=0,sex=?,birthDate=?,idcardNo=?," +
                        "formOfEmployment=?,sourceOfStaff=?,birthDate=?,politicCountenance=?," +
                        "nation=?,nativePlace=?,phone=?,email=?,height=?," +
                        "name=?,maritalStatus=?,birthPlace=?,hukou=?,highestEducation=?," +
                        "highestDegree=?,university=?,majors=?,dateOfGraduation=?,entryDate=?," +
                        "workDate=?,bloodType=?,pid=?,did=?" +
                        " where id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, s.getSex());
                pstmt.setString(2, s.getBirthDate());
            pstmt.setString(3, s.getIdcardNo());
            pstmt.setString(4, s.getFormOfEmployment());
            pstmt.setString(5, s.getSourceOfStaff());
            pstmt.setString(6, s.getBirthDate());
            pstmt.setString(7, s.getPoliticCountenance());
            pstmt.setString(8, s.getNation());
            pstmt.setString(9, s.getNativePlace());
            pstmt.setString(10, s.getPhone());
            pstmt.setString(11, s.getEmail());
            pstmt.setString(12, s.getHeight());
            pstmt.setString(13, s.getName());
            pstmt.setString(14, s.getMaritalStatus());
            pstmt.setString(15, s.getBirthPlace());
            pstmt.setString(16, s.getHukou());
            pstmt.setString(17, s.getHighestEducation());
            pstmt.setString(18, s.getHighestDegree());
            pstmt.setString(19, s.getUniversity());
            pstmt.setString(20, s.getMajors());
            pstmt.setString(21, s.getDateOfGraduation());
            pstmt.setString(22, s.getEntryDate());
            pstmt.setString(23, s.getWorkDate());
            pstmt.setString(24, s.getBloodType());
            pstmt.setString(25, s.getPid());
            pstmt.setString(26, s.getDid());
            pstmt.setString(27, s.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally
        {
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
    }

    @Override
    public void update2(Staff1 s) {

    }
}
