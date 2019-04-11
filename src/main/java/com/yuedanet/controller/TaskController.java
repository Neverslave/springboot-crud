package com.yuedanet.controller;

import com.yuedanet.tasks.AsyncTask;
import com.yuedanet.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private AsyncTask asyncTask;
@RequestMapping("/test")
    public JsonResult dotask1()throws  Exception{
        long start = System.currentTimeMillis();
        Future<Boolean> a =asyncTask.doTask1();
        Future<Boolean> b =asyncTask.doTask2();
        Future<Boolean> c =asyncTask.doTask3();

        while(!a.isDone()||!b.isDone()||!c.isDone()){
            if(a.isDone()&&b.isDone()&&c.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();
        String time = "任务总耗时为"+ (end -start) + " 毫秒";
       return JsonResult.ok(time);
    }
}
