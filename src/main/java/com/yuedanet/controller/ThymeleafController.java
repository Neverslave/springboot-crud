package com.yuedanet.controller;

import com.yuedanet.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RequestMapping("/th")
@Controller
public class ThymeleafController {
    @RequestMapping("/index")
    public String index(ModelMap map){
        User u1  =new User();
        u1.setBirthday(new Date());
        u1.setName("zhu");
        u1.setAge(26);
        u1.setDesc("<font color = 'green'><b>hello thymeleaf</b></font>");
        map.addAttribute("user",u1);
        User u2  =new User();
        u2.setBirthday(new Date());
        u2.setName("zhuwanqi");
        u2.setAge(25);
        u2.setDesc("<font color = 'red'><b>hello thymeleaf</b></font>");

        return "/th/index";

    }

}
