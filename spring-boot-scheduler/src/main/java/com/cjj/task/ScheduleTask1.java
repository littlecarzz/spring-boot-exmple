package com.cjj.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/22 9:31
 */
@Component
public class ScheduleTask1 {

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process() throws Exception{
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
