package com.mipa.osgi.core.schedular;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mipa.osgi.core.ScheduledJob;

public class CoreSchedularProvider {

	private static final CoreSchedularProvider SCHEDULAR_PROVIDER = new CoreSchedularProvider();
	
	private ExecutorService executorService;
	
	public static CoreSchedularProvider getInstance() {
		return SCHEDULAR_PROVIDER;
	}
	
	public void addJob(ScheduledJob job) {
		executorService.execute(job);
	}
	
	public void shutdown() {
		executorService.shutdownNow();
	}
	
	private CoreSchedularProvider() {
		init();
	}
	
	private void init() {
		executorService = Executors.newFixedThreadPool(5);
		Timer timer = new Timer("Main-Collector", true);
		LocalTime time = LocalTime.of(5, 0, 0);
		OffsetDateTime period = OffsetDateTime.of(LocalDate.now(), time, ZoneOffset.UTC);
		Date startTime = new Date(period.toEpochSecond() * 1000);
		timer.scheduleAtFixedRate(new DataCollectorTask(), startTime, (1000*60*60*24));
		System.out.println("Main Data Collector Task is Scheduled...");
	}
}