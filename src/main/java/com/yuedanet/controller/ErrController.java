package com.yuedanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/err")
public class ErrController {
    @RequestMapping("/error")
    public String error(){
        int a =1/0;
        return "th/error";

    }
}
