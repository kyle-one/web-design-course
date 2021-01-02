package com.staffmanage.controller;
import com.google.gson.Gson;
import com.staffmanage.dao.Imp.postDaoImp;
import com.staffmanage.dao.postDao;
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

@WebServlet("/PostDelete")
public class postDelete extends HttpServlet {
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");//设置uft-8编码
        req.setCharacterEncoding("UTF-8");
        String[] pnumList=req.getParameter("pnumList").split(",");
        for(int i=0;i<pnumList.length;i++){
            System.out.println(pnumList[i]);
        }
        postDao pDao=new postDaoImp();
        pDao.deletePost(pnumList);
        req.getRequestDispatcher("postManagement.jsp").forward(req,resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
