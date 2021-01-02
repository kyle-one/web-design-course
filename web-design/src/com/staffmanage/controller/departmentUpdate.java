package com.staffmanage.controller;
import com.google.gson.Gson;
import com.staffmanage.entity.Department;
import com.staffmanage.dao.departmentDao;
import com.staffmanage.dao.Imp.departmentDaoImp;
import javafx.geometry.Pos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DepartmentUpdate")
public class departmentUpdate extends HttpServlet {
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");//设置uft-8编码
        req.setCharacterEncoding("UTF-8");
        Department dp= new Department();

        dp.setDnum(req.getParameter("dnum"));
        dp.setDname(req.getParameter("dname"));
        dp.setType(req.getParameter("type"));
        dp.setParent(req.getParameter("parent"));
        dp.setFax(req.getParameter("fax"));
        dp.setDes(req.getParameter("des"));
        dp.setPhone(req.getParameter("phone"));
        dp.setEstablishDate(req.getParameter("establishDate"));

        departmentDao dDao=new departmentDaoImp();
        dDao.updateDepartment(dp);


        System.out.println("departmentUpdate:"+dp.getDname()+dp.getDnum()+dp.getEstablishDate()+dp.getType());


        req.getRequestDispatcher("departmentManagement.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
