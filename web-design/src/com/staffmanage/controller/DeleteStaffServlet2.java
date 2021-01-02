package com.staffmanage.controller;


import com.staffmanage.entity.Staff1;
import com.staffmanage.entity.staffQuit;
import com.staffmanage.entity.staffTalentPool;
import com.staffmanage.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStaffServlet2")
public class DeleteStaffServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStaffServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //1.接受请求
        response.setContentType("text/html;charset=utf-8");//设置uft-8编码
        request.setCharacterEncoding("UTF-8");


        String id = request.getParameter("id");
        String sex = request.getParameter("sex");
        String birthDate = request.getParameter("birthDate");
        String idcardNo = request.getParameter("idcardNo");
        String sourceOfStaff = request.getParameter("sourceOfStaff");
        String politicCountenance = request.getParameter("politicCountenance");
        String formOfEmployment = request.getParameter("formOfEmployment");
        String nation = request.getParameter("nation");
        String nativePlace = request.getParameter("nativePlace");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String height = request.getParameter("height");
        String name = request.getParameter("name");
        String maritalStatus = request.getParameter("maritalStatus");
        String birthPlace = request.getParameter("birthPlace");
        String Hukou = request.getParameter("Hukou");
        String highestEducation = request.getParameter("highestEducation");
        String highestDegree = request.getParameter("highestDegree");
        String university = request.getParameter("university");
        String sname = request.getParameter("sname");
        String majors = request.getParameter("majors");
        String dateOfGraduation = request.getParameter("dateOfGraduation");
        String entryDate = request.getParameter("entryDate");
        String workDate = request.getParameter("workDate");
        String bloodType = request.getParameter("bloodType");
        String pid = request.getParameter("pid");
        String did = request.getParameter("did");
        String type = request.getParameter("type");
        String quitDate = request.getParameter("departureDate");
        String direction = request.getParameter("direction");
        String remarks = request.getParameter("remarks");
        String enterTalentPool = request.getParameter("enterTalentPool");
        if (enterTalentPool.equals("是"))
        {
            enterTalentPool="1";
        }
        else
            enterTalentPool="0";
        System.out.println(formOfEmployment);
        staffQuit s = new staffQuit(id, sex, birthDate, idcardNo,  sourceOfStaff, politicCountenance, formOfEmployment,nation,
                nativePlace, phone, email, height, name, maritalStatus, birthPlace, Hukou, highestEducation,
                highestDegree, university, majors, dateOfGraduation, entryDate, workDate, bloodType, pid, did, type,
                quitDate, direction, remarks,enterTalentPool);
        staffTalentPool s1 = new staffTalentPool(id, sex, birthDate, idcardNo,  sourceOfStaff, politicCountenance,formOfEmployment, nation,
                nativePlace, phone, email, height, name, maritalStatus, birthPlace, Hukou, highestEducation,
                highestDegree, university, majors, dateOfGraduation, entryDate, workDate, bloodType, pid, did);

        Staff1 s2 = new Staff1(id, sex, birthDate, idcardNo,  sourceOfStaff, politicCountenance,formOfEmployment, nation,
                nativePlace, phone, email, height, name, maritalStatus, birthPlace, Hukou, highestEducation,
                highestDegree, university, majors, dateOfGraduation, entryDate, workDate, bloodType, pid, did);
        //2.根据请求找到某个业务逻辑处理
        staffQuitService sq = new staffQuitServiceImpl();
        sq.addstaffQuit(s);
        if (enterTalentPool.equals("1"))//加入人才库
        {
            staffTalentPoolService stp=new staffTalentPoolServiceImpl();
            stp.addstaffTalentPool(s1);
        }
       staffService ss=new staffServiceImpl();
        ss.delete(id);
//        System.out.println(s.getId());
//        request.setAttribute("s",s);
            //3.找到某个视图响应回去
        request.setAttribute("s", s);
        request.getRequestDispatcher("leavingEmployeeQuery.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }
}
