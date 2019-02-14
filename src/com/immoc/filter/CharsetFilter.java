package com.immoc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符过滤器
 */
public class CharsetFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("中文过滤器工作》》》");
        //把请求的修改成为utf-8
        servletRequest.setCharacterEncoding("UTF-8");
        //告诉其他过滤器本过滤器已经完成过滤工作
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("字符过滤器启动》》》");
    }

    @Override
    public void destroy() {
        System.out.println("字符过滤器销毁》》》");
    }
}
