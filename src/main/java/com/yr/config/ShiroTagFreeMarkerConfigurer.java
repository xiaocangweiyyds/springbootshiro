package com.yr.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.Resource;

@Component
public class ShiroTagFreeMarkerConfigurer implements InitializingBean {

    @Resource
    private Configuration configuration;

    @Resource
    private FreeMarkerViewResolver freeMarkerViewResolver;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 加上这句后，可以在页面上使用shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
        // 加上这句后，可以在页面上用${context.contextPath}获取contextPath
        freeMarkerViewResolver.setRequestContextAttribute("context");
    }
}