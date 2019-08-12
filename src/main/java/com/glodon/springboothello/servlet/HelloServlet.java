package com.glodon.springboothello.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: zhangbh
 * @Date: 2019/8/8 15:27
 * @Description:
 */
@WebServlet(name="helloServlet",urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了HelloServlet的doGet方法。。。。。。");
        resp.getWriter().println("haha,I'm comming");
    }
}
