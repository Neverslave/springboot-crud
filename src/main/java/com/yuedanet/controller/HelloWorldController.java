package com.yuedanet.controller;

import com.yuedanet.pojo.Resource;
import com.yuedanet.pojo.User;
import com.yuedanet.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController //所有方法都以json输出
public class HelloWorldController {
    @Autowired
    private Resource resource;
    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }
    @RequestMapping("/getuser")
    public Object getUser(){
        User user  = new User();
        user.setAge(12);
        user.setName("132123");
        user.setBirthday(new Date());
        return JsonResult.ok(user);

    }

    @RequestMapping("/getResource")
    public JsonResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return JsonResult.ok(bean);

    }
}
