package com.glodon.springboothello.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Auther: zhangbh
 * @Date: 2019/8/8 15:29
 * @Description:
 */
@WebFilter(filterName="helloFilter",urlPatterns="/helloServlet")
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行了前面的代码");

        //放行执行目标资源：HelloServlet
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("执行了后面的代码");
    }

    @Override
    public void destroy() {

    }
}