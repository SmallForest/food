package com.immoc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FoodDeleteServlet")
public class FoodDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id").equals("")){
            request.setAttribute("msg","请输入要删除的ID");
            request.setAttribute("color","red");
            request.getRequestDispatcher("/deleteById.jsp").forward(request,response);
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        ServletContext sc = this.getServletContext();
        List<Food> list = (List<Food>) sc.getAttribute("list");
        List<Food> list1 = new ArrayList<>();
        boolean flag = false;
        for (Food f : list) {
            if (f.getId() != id) {
                list1.add(f);
            }else{
                flag = true;
            }
        }
        sc.setAttribute("list",list1);
        if(flag){
            //删除成功
            request.setAttribute("msg","删除成功！");
            request.setAttribute("color","green");
        }else{
            //没找到元素
            request.setAttribute("msg","删除失败!找不到id");
            request.setAttribute("color","red");
        }
        request.getRequestDispatcher("/deleteById.jsp").forward(request,response);
    }
}
