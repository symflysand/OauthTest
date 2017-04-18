package com.flysand.matcher;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Title:CsrfSecurityMatcher.java
 * Location:com.flysand.matcher
 * Author:flysand
 * Date:2017年04月13 16:07:40
 * Description:
 **/
public class CsrfSecurityMatcher implements RequestMatcher {

    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

    private List<String> execludeUrls;

    public boolean matches(HttpServletRequest request) {

        if(execludeUrls !=null && execludeUrls.size()>0){
            String servletPath =request.getServletPath();
            for(String url : execludeUrls){
                if(servletPath.contains(url)){
                    return false;
                }
            }
        }

        return !allowedMethods.matcher(request.getMethod()).matches();
    }


    public List<String> getExecludeUrls() {
        return execludeUrls;
    }

    public void setExecludeUrls(List<String> execludeUrls) {
        this.execludeUrls = execludeUrls;
    }
}
