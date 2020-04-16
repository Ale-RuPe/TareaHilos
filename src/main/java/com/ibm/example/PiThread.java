package com.ibm.example;

import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PiThread  implements Runnable{
	private Aproximacion aprox;
	private int range;
	private CountDownLatch countDownLatch;
	
	public PiThread(Aproximacion aprox, int range, CountDownLatch countDownLatch) {
		this.aprox = aprox;
		this.range = range;
		this.countDownLatch = countDownLatch;
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i < range; i++) {
			double x = Math.random();
			double y = Math.random();
			this.aprox.incrementaTrialCount();
			if (x * x + y * y < 1) {
				this.aprox.incrementaInCircleCount();
			}
		}
		log.info("Thread finished");
		countDownLatch.countDown();
	}

}
