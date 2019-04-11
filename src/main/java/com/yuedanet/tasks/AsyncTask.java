package com.yuedanet.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.Future;

@Component
public class AsyncTask {
    @Async
    public Future<Boolean> doTask1() throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务一耗时"+" "+(end-start)+ " 毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask2() throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        System.out.println("任务二耗时"+" "+(end-start)+ " 毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask3() throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long end = System.currentTimeMillis();
        System.out.println("任务三耗时"+" "+(end-start)+ " 毫秒");
        return new AsyncResult<>(true);
    }
}
