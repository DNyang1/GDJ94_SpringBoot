package com.winter.app.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleTest {

//	@Scheduled(fixedDelay = 1000)
	public void s1() {
		System.out.println("일정간격~");
	}
//	@Scheduled(fixedRate = 2000, initialDelayString = "1000")
	public void s2() {
		System.out.println("고정간격~");
	}
	
	@Scheduled(cron="* * * * * *")
	public void s3() {
		System.out.println("고정간격~");
	}
	
}
