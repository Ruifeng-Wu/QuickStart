package com.ruifeng.quickstart.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
public class ConsumerAppScheduler {


    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleConsumerAppSyncWithKong() {
        log.debug("Consumer App sync with kong scheduler startup.");

        log.debug("Consumer App sync with kong scheduler complete.");
    }
}
