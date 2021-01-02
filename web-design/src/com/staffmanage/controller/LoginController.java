package com.staffmanage.controller;

import com.staffmanage.dao.Imp.LoginDaoImp;
import com.staffmanage.dao.LoginDao;
import com.staffmanage.entity.Administrators;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        Administrators admin;

        LoginDao loginDao = new LoginDaoImp();
        admin = loginDao.getUserAndPassword(name,password);

        //System.out.println(admin.getUsername());
        //System.out.println(admin.getPwd());

        if(admin.getUsername() != null && admin.getPwd() != null){
            HttpSession session = req.getSession();
            session.setAttribute("token",admin.getSession());
            //resp.addCookie(new Cookie("cookie",admin.getSession()));
            resp.sendRedirect("index.html");
            //req.getRequestDispatcher("index.html").forward(req,resp);
        }else{
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
