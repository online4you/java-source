package com.pRemote.pCell.scheduling.cron;

import java.io.IOException;

import org.quartz.SchedulerException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SchedulerException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, SchedulerException, InterruptedException {
		// TODO Auto-generated method stub
		Cron cron = new Cron("cron.txt", "cell0001");
		cron.cronTasks();
		cron.shutdown();
	}

}
