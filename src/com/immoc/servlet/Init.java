package com.immoc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

public class Init extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //创建一个集合用于保存食物的信息
        List<Food> list = new ArrayList<>();
        this.getServletContext().setAttribute("list", list);
    }
}
