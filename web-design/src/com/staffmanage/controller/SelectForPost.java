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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectForPost")
public class SelectForPost extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectForPost() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //1.接受请求
          postDao pd=new postDaoImp();
          List<Post> pl=pd.getAllPost();

        PrintWriter pw=response.getWriter();
        for (Post post:pl)
        {
            pw.println("<option value="+post.getPnum()+">"+post.getPname()+"</option>");
        }


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }
}
