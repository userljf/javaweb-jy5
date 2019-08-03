package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.service.ProductService;
import com.itdr.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.itdr.utils.PathUTil.getpath;

@WebServlet(name = "ProductController",value = "/manage/product/*")
public class ProductController extends HttpServlet {
    private ProductService ps=new ProductService();
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String pathInfo=request.getPathInfo();
        String path= getpath(pathInfo);
        ; ResponseCode rs=null;
        switch (path){
            case "list":
                rs= lisDo(request);
                break;
            case "login":
                rs=loginDo(request);
                break;


        }

        response.getWriter().write(rs.toString());
    }
    private ResponseCode lisDo(HttpServletRequest request){
        ResponseCode rs=new ResponseCode();
        HttpSession session=request.getSession();
        Product user=(Product) session.getAttribute("user");
        if(user==null){
            rs.setStatus(3);
            rs.setMag("请登录后操作！");
            return  rs;
        }

        String pageSize= request.getParameter("pageSize");
        String pageNum=request.getParameter("pageNum");
        return  rs=ps.selectAll(pageSize,pageNum);
    }
    private ResponseCode loginDo(HttpServletRequest request){
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        ResponseCode rs= ps.selectOne(username, password);
        HttpSession session =request.getSession();
        session.setAttribute("user",rs.getData());
        return  rs;
    }

}
