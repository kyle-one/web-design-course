package com.staffmanage.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.staffmanage.dao.Imp.changeDepartmentImp;
import com.staffmanage.dao.Imp.departmentTransferDaoImp;
import com.staffmanage.dao.Imp.postTransferDaoImp;
import com.staffmanage.dao.departmentTransferDao;
import com.staffmanage.dao.postTransferDao;
import com.staffmanage.entity.Department;
import com.staffmanage.entity.DepartmentTransfer;
import com.staffmanage.entity.Post;
import com.staffmanage.entity.view.DepartmentTransferView;
import com.staffmanage.entity.view.PostTransferView;
import com.staffmanage.entity.view.changeDepartmentView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getPostTransfer")
public class postTransferController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String starttime = req.getParameter("starttime");
        String endtime = req.getParameter("endtime");
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String type = req.getParameter("type");
        resp.setContentType("text/html;charset=utf-8");//设置uft-8编码

        List<PostTransferView> ptlist;

        postTransferDao dtd = new postTransferDaoImp();

        ptlist = dtd.getByTimeAndSidAndSnameAndType(starttime,endtime,sid,sname,type);

//        req.setAttribute("postList",postList);
//        req.setAttribute("departmentList",departmentList);
//
        Gson gson= new Gson();
        JsonObject jsonObject = new JsonObject();
        //jsonObject.addProperty("limit",staffList.size());
        //jsonObject.addProperty("rows",gson.toJson(staffList));
        //System.out.println(jsonObject);
        resp.getWriter().write(gson.toJson(ptlist));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
