package com.staffmanage.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/index.html")
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        //boolean isLogined = false;
        HttpSession session = req.getSession();
        String token = String.valueOf( session.getAttribute("token"));
        if ("null".equals(token)) {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        /*
        Cookie[] cookies = req.getCookies();
        if(cookies == null){
            resp.sendRedirect("login.jsp");
        }
        for(Cookie cookie:cookies){
            if(cookie.getName() == "cookie" && cookie.getValue()!=null){
                isLogined = true;
            }
        }
        if(isLogined == false){
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }*/
    }

    @Override
    public void destroy() {

    }
}
