package com.staffmanage.controller;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.staffmanage.dao.Imp.changeDepartmentImp;
import com.staffmanage.dao.changeDepartmentDao;
import com.staffmanage.entity.Department;
import com.staffmanage.entity.Post;
import com.staffmanage.entity.view.changeDepartmentView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changeDepartment")
public class departmentChangeController extends HttpServlet {
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String did = req.getParameter("did");
        String dname = req.getParameter("dname");
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        resp.setContentType("text/html;charset=utf-8");//设置uft-8编码

        List<changeDepartmentView> staffList;
        List<Post> postList;
        List<Department> departmentList;

        changeDepartmentImp cdd = new changeDepartmentImp();

        staffList = cdd.getByDidAndDnameAndSidAndSname(did,dname,sid,sname);
        departmentList = cdd.getAllDepartment();
        postList = cdd.getAllPost();
        req.setAttribute("postList",postList);
        req.setAttribute("departmentList",departmentList);

        Gson gson= new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("limit",staffList.size());
        jsonObject.addProperty("rows",gson.toJson(staffList));
        //System.out.println(jsonObject);
        resp.getWriter().write(gson.toJson(staffList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
