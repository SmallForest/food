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

@WebServlet("/SelectFoodByNameServlet")
public class selectFoodByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("foodName");
        ServletContext sc = this.getServletContext();
        List<Food> list = (List<Food>) sc.getAttribute("list");
        List<Food> list1 = new ArrayList<>();
        boolean flag = false;
        for (Food f:list){
            if (f.getName().equals(name)){
                flag = true;
                list1.add(f);
            }
        }
        if(flag){
            System.out.println(list1);
            request.setAttribute("list1",list1);
            request.getRequestDispatcher("/showFoodList.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","没有找到该菜品");
            request.getRequestDispatcher("/selectFoodByName.jsp").forward(request,response);

        }

    }
}
