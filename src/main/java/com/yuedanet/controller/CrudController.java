package com.yuedanet.controller;

import com.yuedanet.pojo.User;
import com.yuedanet.serviceImpl.UserServiceImpl;
import com.yuedanet.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class CrudController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/saveUser")
    public JsonResult saveUser() throws Exception{
        User user = new User();
        //user.setId(1);
        user.setUsername("zhu");
        user.setPassword("111222333");
        user.setStatus("0");
        user.setCreateTime(new Date());
        userService.saveUser(user);
        return JsonResult.ok("保存成功");
    }
    @RequestMapping("/updateUser")
    public JsonResult updateUser(){
        User user = new User();
        user.setUsername("111");
        user.setId(1);
        user.setStatus("1");
        userService.updateUser(user);
        return JsonResult.ok("修改成功");

    }
    @RequestMapping("/deleteUser")
    public JsonResult deleteUser(){

        userService.deleteUser(2);
        return JsonResult.ok("删除成功");

    }
    @RequestMapping("/queryUserListPaged")
    public JsonResult queryUserListPaged(Integer page){
        if(page == null){
            page =1;
        }
        int pageSize = 10;
        User user = new User();
        user.setUsername("zhu");
        List<User> userList = userService.queryUserListPaged(user,page,10);
        return JsonResult.ok(userList);
    }
    @RequestMapping("/queryUserSimplyInfoById")
    public JsonResult queryUserByIdCustom(Integer id){
        return JsonResult.ok(userService.queryUserByIdCustom(id));
    }


}
