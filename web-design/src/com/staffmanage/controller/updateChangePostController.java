package com.staffmanage.controller;

import com.staffmanage.dao.Imp.departmentTransferDaoImp;
import com.staffmanage.dao.Imp.postTransferDaoImp;
import com.staffmanage.dao.Imp.updateChangeImp;
import com.staffmanage.dao.departmentTransferDao;
import com.staffmanage.dao.postTransferDao;
import com.staffmanage.dao.staffDao;
import com.staffmanage.entity.DepartmentTransfer;
import com.staffmanage.entity.PostTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateChangePost")
public class updateChangePostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        System.out.println("controller sid:"+sid);
        String pid1 = req.getParameter("pid1");
        String pid2 = req.getParameter("pid2");
        System.out.println("controller pid2:"+pid2);
        String tdate = req.getParameter("tdate");
        String reason = req.getParameter("reason");
        String remarks = req.getParameter("remarks");
        String type = req.getParameter("type");
        PostTransfer postTransfer = new PostTransfer(sid,pid1,pid2,tdate,reason,remarks,type,0);

        staffDao sd = new updateChangeImp();
        postTransferDao ptd = new postTransferDaoImp();
        //System.out.println("did2="+did2);
        sd.updateStaffPost(pid2,sid);
        ptd.add(postTransfer);
        resp.sendRedirect("/changePost.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
