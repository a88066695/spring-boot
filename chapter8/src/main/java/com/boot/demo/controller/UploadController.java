package com.boot.demo.controller;

import com.boot.demo.service.UploadService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/upload/index");
        return mv;
    }

    @RequestMapping("uploadFile")
    @ResponseBody
    public Map uploadFile(@RequestParam(name = "file") MultipartFile[] file){
        Map<String,String> result = new HashMap<>();
        try {
            uploadService.uploadFile(file);
            result.put("code","200");
            result.put("msg","上传成功");
        } catch (Exception e){
            result.put("code","500");
            result.put("msg","上传失败");
        }
        return result;
    }

    @RequestMapping("uploadBase64File")
    @ResponseBody
    public Map uploadFile(@RequestParam String baseStr){
        Map<String,String> result = new HashMap<>();
        try {
            uploadService.uploadBase64File(baseStr);
            result.put("code","200");
            result.put("msg","上传成功");
        } catch (Exception e){
            result.put("code","500");
            result.put("msg","上传失败");
        }
        return result;
    }
}
