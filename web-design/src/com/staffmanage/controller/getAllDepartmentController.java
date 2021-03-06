package com.staffmanage.controller;

import com.google.gson.Gson;
import com.staffmanage.dao.Imp.departmentDaoImp;
import com.staffmanage.dao.Imp.postDaoImp;
import com.staffmanage.dao.departmentDao;
import com.staffmanage.dao.postDao;
import com.staffmanage.entity.Department;
import com.staffmanage.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAllDepartment")
public class getAllDepartmentController extends HttpServlet{
        Gson gson = new Gson();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=utf-8");//设置uft-8编码
            List<Department> departmentList;

            departmentDao dd = new departmentDaoImp();
            departmentList = dd.getAllDepartment();

            Gson gson = new Gson();
            String staffJson = gson.toJson(departmentList);
            System.out.println(staffJson);
            resp.getWriter().write(staffJson);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req, resp);
        }
}

