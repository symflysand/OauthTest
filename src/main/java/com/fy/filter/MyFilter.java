package com.fy.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Title:MyFilter.java
 * Location:com.fy.filter
 * Author:flysand
 * Date:2017年07月21 14:10:48
 * Description:
 **/
@Component("myFilter")
public class MyFilter implements Filter {

    //filter会在web.xml中加载优先于spring的加载，因此要想在filter中加入spring bean的引入就会是null，
    //通过DelegatingFilterProxy代理，就会把filter的生命周期交给spring来维护，可以在加载spring的时候把filter中相应的bean都加载进来

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //...具体过滤器内容
    }
}
