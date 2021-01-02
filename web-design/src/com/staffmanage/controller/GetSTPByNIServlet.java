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
import com.staffmanage.entity.staffTalentPool;
import com.staffmanage.service.staffService;
import com.staffmanage.service.staffServiceImpl;
import com.staffmanage.service.staffTalentPoolService;
import com.staffmanage.service.staffTalentPoolServiceImpl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetSTPByNIServlet")
public class GetSTPByNIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSTPByNIServlet() {
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


        String name=request.getParameter("name");
        String idcardNo=request.getParameter("idcardNo");


        //2.根据请求找到某个业务逻辑处理

//        List<Staff> staffList;
//
//        staffDao1 sd=new staffDaoImpl();


        staffTalentPoolService ss=new staffTalentPoolServiceImpl();
        List<staffTalentPool> stas=new ArrayList<staffTalentPool>();
        stas=ss.getstafftpByNI(name,idcardNo);
//          request.setAttribute("stas", stas);



        Gson gson= new Gson();
        String staffJson = gson.toJson(stas);
        System.out.println(staffJson);
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
