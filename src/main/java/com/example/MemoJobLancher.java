package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MemoJobLancher {
	
	@Autowired
	  private JobLauncher jobLauncher;

	@Autowired
	  private Job memoJob;
	
	private JobParameters jobParameters;
	
	@Scheduled(initialDelay = 5000, fixedRate = 5000)//5ïbÇ®Ç´Ç…é¿çs
	public void batch() {
		try {
			jobParameters = memoJob.getJobParametersIncrementer().getNext(jobParameters);
			jobLauncher.run(memoJob, jobParameters);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
