package com.boot.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("auth/login")
    public ModelAndView login(HttpServletRequest request){
        SecurityUtils.getSubject().logout();
        ModelAndView mv = new ModelAndView();
        String error = (String)request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        logger.info("error : {}",error);
        if(null != error && !"".equals(error)){
            if(UnknownAccountException.class.getName().equals(error)){
                mv.addObject("error","账号不存在");
            } else if(IncorrectCredentialsException.class.getName().equals(error)){
                mv.addObject("error","密码错误");
            }
        }
        mv.setViewName("auth/login");
        return mv;
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        logger.info("登录信息 principal : {}", SecurityUtils.getSubject().getPrincipal());
        return "Hello World";
    }
}
