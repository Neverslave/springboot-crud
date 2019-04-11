package com.yuedanet.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.yuedanet.pojo.User;
import com.yuedanet.serviceImpl.UserServiceImpl;
import com.yuedanet.utils.JsonResult;
import com.yuedanet.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.cdi.RedisKeyValueTemplateBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private StringRedisTemplate StrRedis;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/test")
    public JsonResult test(){
        StrRedis.opsForValue().set("name","Leborn James");
       User user =userService.queryUserById(11);

      JSON str =(JSON) JSON.toJSON(user);
       StrRedis.opsForValue().set("json:user",str.toJSONString());


        return JsonResult.ok(StrRedis.opsForValue().get("json:user"));
    }

    @RequestMapping("/test2")
    public JsonResult test2(){
        User user = new User();
        user.setUsername("zhu");
        List<User> users = userService.queryUserListPaged(user,1,20);
        redisUtil.set("json:users",JSON.toJSONString(users));
        return JsonResult.ok(redisUtil.get("json:users"));

    }



}
