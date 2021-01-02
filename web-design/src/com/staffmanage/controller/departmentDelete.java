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

@WebServlet("/DepartmentDelete")
public class departmentDelete extends HttpServlet {
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");//设置uft-8编码
        req.setCharacterEncoding("UTF-8");
        //List<String> dnumList;
        String[] dnumList=req.getParameter("dnumList").split(",");
        for(int i=0;i<dnumList.length;i++){
            System.out.println(dnumList[i]);
        }

        departmentDao dDao=new departmentDaoImp();
        dDao.deleteDepartment(dnumList);


        //System.out.println("gfdgfdgfd:"+dname);
        req.getRequestDispatcher("departmentManagement.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
