package com.ibm.example;

import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContadorThread implements Runnable {
  
  Contador cont;
  int range;
  CountDownLatch countDownLatch;

  public ContadorThread(Contador cont, int range, CountDownLatch countDownLatch) {
    this.cont = cont;
    this.range = range;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    for (int i = 0; i < range; i++) {
      this.cont.incrementaCuenta();
    }
    log.info("Thread finished");
    countDownLatch.countDown();
  }

}
