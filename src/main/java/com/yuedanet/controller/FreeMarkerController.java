package com.yuedanet.controller;

import com.yuedanet.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("ftl")
@Controller
public class FreeMarkerController {

    @Autowired
    private Resource resource;
    @RequestMapping("/index")
    public String index(){
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center(ModelMap map){
        map.addAttribute("resource",resource);
        return "freemarker/center";
    }



}
