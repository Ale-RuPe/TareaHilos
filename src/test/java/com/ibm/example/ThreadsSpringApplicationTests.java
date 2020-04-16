package com.ibm.example;

import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ThreadsSpringApplicationTests {

  @Autowired
  ThreadPoolTaskExecutor taskExecutor;

  @Test
  void contextLoads() throws InterruptedException {

    Contador cont = new Contador();
    
    int numThreads = 6;
    
    CountDownLatch countDownLatch = new CountDownLatch(numThreads);
    
    for(int i = 0; i < numThreads; i++) {
      taskExecutor.execute(new ContadorThread(cont, 4000000, countDownLatch));
    }
    
    countDownLatch.await();
    System.out.println("cuenta: " + cont.getCuenta());
  }
  
  @Test
  public void test_pi_uno() throws InterruptedException {
	  
	  	Aproximacion aprox = new Aproximacion();
	    int numThreads = 5;
	    int range = 250000;
	    CountDownLatch countDownLatch = new CountDownLatch(numThreads);
	    
	    for(int i = 0; i < numThreads; i++) {
	    	taskExecutor.execute(new PiThread(aprox, range, countDownLatch));
	    }
	    
	    countDownLatch.await();
	    Double estimateForPi =  4 * ( (double)aprox.getInCircleCount().get()/ aprox.getTrialCount().get());
	    
	    log.info("Number of trials: {}", aprox.getInCircleCount().get());
	    log.info("Current Estimate: {} ", estimateForPi);
	    double tiempo = System.currentTimeMillis()/1000;
	    log.info("Time {}", tiempo);
  }
  
  @Test
  public void test_pi_dos() throws InterruptedException {

	  	Aproximacion aprox = new Aproximacion();
	    int numThreads = 100;
	    int range = 10000;
	    CountDownLatch countDownLatch = new CountDownLatch(numThreads);
	    
	    for(int i = 0; i < numThreads; i++) {
	    	taskExecutor.execute(new PiThread(aprox, range, countDownLatch));
	    }
	    
	    countDownLatch.await();
	    Double estimateForPi =  4 * ( (double)aprox.getInCircleCount().get()/ aprox.getTrialCount().get());
	    
	    
	    log.info("Number of trials: {}", aprox.getInCircleCount().get());
	    log.info("Current Estimate: {} ", estimateForPi);
	    
	    double tiempo = System.currentTimeMillis()/1000;
	    log.info("Time {}", tiempo);
  }
  
  @Test
  public void test_pi_tres() throws InterruptedException {
	  	Aproximacion aprox = new Aproximacion();
	    int numThreads = 10000;
	    int range = 100;
	    CountDownLatch countDownLatch = new CountDownLatch(numThreads);
	    
	    for(int i = 0; i < numThreads; i++) {
	    	taskExecutor.execute(new PiThread(aprox, range, countDownLatch));
	    }
	    
	    countDownLatch.await();
	    Double estimateForPi =  4 * ( (double)aprox.getInCircleCount().get()/ aprox.getTrialCount().get());
	    
	    log.info("Number of trials: {}", aprox.getInCircleCount().get());
	    log.info("Current Estimate: {} ", estimateForPi);
	    
	    double tiempo = System.currentTimeMillis()/1000;
	    log.info("Time {}", tiempo);
  }
   
}
