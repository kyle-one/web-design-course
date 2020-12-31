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

@WebServlet("/temp")
public class temp extends HttpServlet {
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");//设置uft-8编码

        String dname=req.getParameter("dname");
        String dnum=req.getParameter("dnum");
        String type=req.getParameter("type");
        req.setAttribute("dname",dname);
        req.setAttribute("dnum",dnum);
        req.setAttribute("type",type);
        System.out.println("TEMP"+dname+dnum+type);


        req.getRequestDispatcher("Department").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
