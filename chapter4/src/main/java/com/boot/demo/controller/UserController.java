package com.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/home")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        Map<String,Object> info = new HashMap<>();
        info.put("username","Ivan");
        info.put("message","this is a message");
        mv.addObject("info",info);
        return mv;
    }

}
