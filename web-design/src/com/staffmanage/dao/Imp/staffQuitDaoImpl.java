package com.staffmanage.dao.Imp;

import com.staffmanage.Utils.DbUtils;
import com.staffmanage.dao.staffQuitDao;
import com.staffmanage.entity.staffQuit;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class staffQuitDaoImpl implements staffQuitDao {
    @Override
    public void addstaffQuit(staffQuit s) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbUtils.getConnection();
            String sql = "insert into staffquit(id,sex,birthDate,idcardNo,formOfEmployment,sourceOfStaff,politicCountenance," +
                    "nation,nativePlace,phone,email,height,name,maritalStatus, birthPlace,Hukou, highestEducation," +
                    "highestDegree,university,majors,dateOfGraduation,entryDate,workDate,bloodType,pid,did,type,quitDate," +
                    "direction,remarks) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            System.out.println();
            System.out.print(s.getFormOfEmployment());
            System.out.print(s.getPoliticCountenance());
            System.out.print(s.getNation());
            System.out.print(s.getFormOfEmployment());
            pstmt.setString(1, s.getId());
            pstmt.setString(2, s.getSex());
            pstmt.setString(3, s.getBirthDate());
            pstmt.setString(4, s.getIdcardNo());
            pstmt.setString(5, s.getFormOfEmployment());
            pstmt.setString(6, "校园招聘");
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
            pstmt.setString(27, s.getType());
            pstmt.setString(28, s.getQuitDate());
            pstmt.setString(29, s.getDirection());
            pstmt.setString(30, s.getRemarks());
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
    public List<staffQuit> getstaffQuitByINDPTSE(String id, String name, String dname, String pname, String type, String startDayte, String endDate) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<staffQuit> s = new ArrayList<staffQuit>();
        try {
            conn = DbUtils.getConnection();
            System.out.println("conn:" + conn);


            String sql = "select  *  from staffquit where 1=1";
            int i = 1;
            if (id != null && !id.trim().isEmpty()) {
                sql = sql + " and id=? ";

            }
            if (name != null && !name.trim().isEmpty()) {
                sql = sql + " and name=? ";

            }
            if (dname != null && !dname.trim().isEmpty()) {
                sql = sql + " and did= (select dnum from department where dname=?) ";

            }
            if (pname != null && !pname.trim().isEmpty()) {
                sql = sql + " and pid=(select pnum from post where pname=?)";

            }
            if (type != null && !type.trim().isEmpty()) {
                sql = sql + " and type=? ";

            }
            if (startDayte != null && !startDayte.trim().isEmpty()) {
                sql = sql + " and quitDate >=?";

            }
            if (endDate != null && !endDate.trim().isEmpty()) {
                sql = sql + " and quitDate <= ?";

            }
            pstmt = conn.prepareStatement(sql);
            System.out.println(sql);
            if (id != null && !id.trim().isEmpty()) {

                pstmt.setString(i++, id);
            }
            if (name != null && !name.trim().isEmpty()) {

                pstmt.setString(i++, name);
            }
            if (dname != null && !dname.trim().isEmpty()) {

                pstmt.setString(i++, dname);
            }
            if (pname != null && !pname.trim().isEmpty()) {

                pstmt.setString(i++, dname);
            }
            if (type != null && !type.trim().isEmpty()) {

                pstmt.setString(i++, type);
            }
            if (startDayte != null && !startDayte.trim().isEmpty()) {

                pstmt.setString(i++, id);
            }
            if (endDate != null && !endDate.trim().isEmpty()) {

                pstmt.setString(i++, id);
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                staffQuit s1 = new staffQuit();
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
                s1.setType(rs.getString("type"));
                s1.setQuitDate(rs.getString("quitDate"));
                s1.setDirection(rs.getString("direction"));
                s1.setRemarks(rs.getString("remarks"));
                s.add(s1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtils.closeResultSet(rs);
            DbUtils.closeStatement(pstmt);
            DbUtils.closeConnection();
        }
        return s;
    }

}
