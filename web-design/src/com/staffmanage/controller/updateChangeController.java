package com.staffmanage.controller;

import com.staffmanage.dao.Imp.departmentTransferDaoImp;
import com.staffmanage.dao.Imp.updateChangeImp;
import com.staffmanage.dao.departmentTransferDao;
import com.staffmanage.dao.staffDao;
import com.staffmanage.entity.DepartmentTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateChange")
public class updateChangeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        String did1 = req.getParameter("did1");
        String did2 = req.getParameter("did2");
        String tdate = req.getParameter("tdate");
        String reason = req.getParameter("reason");
        String remarks = req.getParameter("remarks");
        String type = req.getParameter("type");
        DepartmentTransfer departmentTransfer = new DepartmentTransfer(sid,did1,did2,tdate,reason,remarks,type,0);

        staffDao sd = new updateChangeImp();
        departmentTransferDao dtd = new departmentTransferDaoImp();
        System.out.println("did2="+did2);
        sd.updateStaffDepartment(did2,sid);
        dtd.add(departmentTransfer);
        resp.sendRedirect("/changeDepartment.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
