package com.immoc.servlet;

import com.immoc.utils.UploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/FoodAddServlet")
public class FoodAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理enctype的四个步骤
            // 1.创建一个磁盘文件项工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            // 2.创建一个核心的解析类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            // 3.解析request请求返回的是list
            List<FileItem> list = servletFileUpload.parseRequest(request);
            //声明map存储表单元素
            HashMap<String, String> map = new HashMap<>();
            //对象保存地址默认为空字符串
            String save_url = "";
            for (FileItem fileItem : list) {
                //判断是不是表单项
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println(name + "    " + value);
                    map.put(name, value);
                } else {
                    //上传图片
                    //1.获取文件名
                    String fileName = fileItem.getName();
                    if (fileName != null && !"".equals(fileName)) {
                        //生成唯一文件名
                        fileName = UploadUtils.getUUIDFileName(fileName);
                        // 2.获取文件输入流
                        InputStream is = fileItem.getInputStream();
                        // 3.生成真实的存储路径
                        String real_url = this.getServletContext().getRealPath("/upload") + "/" + fileName;
                        //用于对象存储
                        save_url = "/upload/" + fileName;
                        // 4.保存图片到real_url 输入流对接到输出流
                        OutputStream os = new FileOutputStream(real_url);
                        int len;
                        byte[] b = new byte[1204];
                        while ((len = is.read(b)) != -1) {
                            os.write(b, 0, len);
                        }
                        is.close();
                        os.close();

                    }
                }
            }
            //获取servletContext判断ID是否重复！
            ServletContext sc = this.getServletContext();
            //获取存储的数据

            List<Food> list1 = (List<Food>) sc.getAttribute("list");
            if (map.get("type").equals("add")) {
                //校验ID
                for (Food f : list1) {
                    if (f.getId() == Integer.parseInt(map.get("id"))) {
                        request.setAttribute("msg", "ID重复！");
                        request.getRequestDispatcher("/addFood.jsp").forward(request, response);
                        return;
                    }
                }
            } else if (map.get("type").equals("update")) {
                //校验ID,如果是更新就把存在的删除 不存在的添加
                List<Food> list2 = new ArrayList<>();
                boolean flag = false;

                for (Food f : list1) {
                    if (f.getId() != Integer.parseInt(map.get("id"))) {
                        list2.add(f);
                    }else{
                        flag = true;
                    }
                }
                if (!flag){
                    //如果flag还是false说明没有找到id
                    request.setAttribute("msg", "ID没找到！");
                    request.getRequestDispatcher("/updateFood.jsp").forward(request, response);
                    return;
                }
                list1 = list2;
            }
            //生成food对象并存储到list1
            Food f = new Food();
            if(map.get("id").equals("") || map.get("foodName").equals("") || map.get("price").equals("")){
                request.setAttribute("msg", "ID，名称，价格必须填写！");
                request.getRequestDispatcher("/addFood.jsp").forward(request, response);
                return;
            }
            f.setId(Integer.parseInt(map.get("id")));
            f.setTaste(map.get("taste"));
            f.setName(map.get("foodName"));
            f.setUrl(save_url);
            f.setPrice(Double.parseDouble(map.get("price")));
            f.setDescribe(map.get("description"));
            list1.add(f);
            //list1存入到servletContext
            sc.setAttribute("list", list1);
            //跳转到菜品列表
            response.sendRedirect(request.getContextPath() + "/selectFoodServlet");


        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
