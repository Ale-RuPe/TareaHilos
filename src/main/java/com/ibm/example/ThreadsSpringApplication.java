package com.ibm.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class ThreadsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadsSpringApplication.class, args);
	}
	
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
	  ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	  executor.initialize();
	  return executor;
	}

}
