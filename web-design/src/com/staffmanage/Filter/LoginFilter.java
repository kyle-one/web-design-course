package com.staffmanage.Filter;

import com.staffmanage.dao.Imp.LoginDaoImp;
import com.staffmanage.dao.LoginDao;
import com.staffmanage.entity.Administrators;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/temptemptemp")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        Administrators admin;

        LoginDao loginDao = new LoginDaoImp();
        admin = loginDao.getUserAndPassword(name,password);

        System.out.println(admin.getUsername());
        System.out.println(admin.getPwd());

        if(admin.getUsername() != null && admin.getPwd() != null){
            resp.addCookie(new Cookie("cookie",admin.getSession()));
            resp.sendRedirect("/web_design_war_exploded/index.html");
        }else{
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

        filterChain.doFilter(servletRequest, servletResponse);//调用下一个过滤器或者请求资源
    }

    @Override
    public void destroy() {

    }
}
