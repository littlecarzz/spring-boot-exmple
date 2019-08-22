package com.cjj.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/22 9:35
 */
@Component
public class ScheduleTask2 {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() throws Exception{
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
