package com.yr.config.shiro.filter;

import com.yr.config.shiro.realm.MyRealm;
import com.yr.entity.UPermission;
import com.yr.service.LoginService;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component("permission")
public class PermissionFilter extends AccessControlFilter {

    @Autowired
    private LoginService loginService;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String uri = httpServletRequest.getRequestURI();
        String basePath = httpServletRequest.getContextPath();

        if (null != uri && uri.startsWith(basePath)) {
            uri = uri.replaceFirst(basePath, "");
        }

        List<UPermission> list = MyRealm.map.get(subject.getPrincipal());
        if (null != list) {
            for (UPermission uPermission : list) {
                if (uri.matches(uPermission.getUrl()) && uPermission.getType().equalsIgnoreCase(httpServletRequest.getMethod())) {
                    return true;
                }
            }
        }

//        if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) servletRequest).getHeader("X-Requested-With"))) {
//            //进来这里就代表这是ajax请求
//        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        if (null == subject.getPrincipal()) {
            //没登录 重定向到登录页面
            saveRequest(servletRequest);
            WebUtils.issueRedirect(servletRequest, servletResponse, "/login");
        } else {
            //没权限 跳转到没权限页面
            WebUtils.issueRedirect(servletRequest, servletResponse, "/unauthorized");
        }
        return false;
    }

}
