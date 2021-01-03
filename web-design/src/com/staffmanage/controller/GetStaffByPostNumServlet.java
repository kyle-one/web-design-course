package com.staffmanage.controller;




import com.google.gson.Gson;
import com.staffmanage.dao.Imp.departmentDaoImp;
import com.staffmanage.dao.Imp.postDaoImp;
import com.staffmanage.dao.Imp.staffDaoImpl;
import com.staffmanage.dao.departmentDao;
import com.staffmanage.dao.postDao;
import com.staffmanage.dao.staffDao1;
import com.staffmanage.entity.Department;
import com.staffmanage.entity.Post;
import com.staffmanage.entity.Staff;
import com.staffmanage.entity.Staff1;
import com.staffmanage.service.staffService;
import com.staffmanage.service.staffServiceImpl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetStaffByPostNumServlet")
public class GetStaffByPostNumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStaffByPostNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //1.接受请求

        response.setContentType("text/html;charset=utf-8");//设置uft-8编码


//        postDao pd = new postDaoImp();
//        departmentDao dd = new departmentDaoImp();




        String pid=request.getParameter("pid");
        System.out.println("222222222222"+pid);


        //2.根据请求找到某个业务逻辑处理

//        List<Staff> staffList;
//
//        staffDao1 sd=new staffDaoImpl();


        staffService ss=new staffServiceImpl();
        List<Staff1> stas=new ArrayList<Staff1>();
        stas=ss.getStaffByPostNum(pid);
//          request.setAttribute("stas", stas);



        Gson gson= new Gson();
        String staffJson = gson.toJson(stas);
//        System.out.println(staffJson);
        response.getWriter().write(staffJson);


        //3.找到某个视图响应回去
//        request.getRequestDispatcher("employeeTurnoverManagement.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }
}
