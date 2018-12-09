package com.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledDemo {
    @Scheduled(cron = "0/2 * * * * ?")
    public void fun() {
        System.out.println("SSSSSSSSSSSSSSSS");
    }
}
