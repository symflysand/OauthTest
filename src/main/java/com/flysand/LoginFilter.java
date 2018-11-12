package com.flysand;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Title:LoginFilter.java
 * Location:com.flysand
 * Author:flysand
 * Date:2017年06月30 15:58:16
 * Description:
 **/
public class LoginFilter implements Filter {



    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getParameter("token");
        if(null == token || "".equals(token)){
            System.out.println("不存在");
        }else {
            System.out.println("存在");
        }


        filterChain.doFilter(request,response);

    }
}
