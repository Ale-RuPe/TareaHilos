package com.ibm.example;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;

@Getter
public class Aproximacion {
	private AtomicLong trialCount = new AtomicLong();
    private AtomicLong inCircleCount = new AtomicLong();
    
    public void incrementaTrialCount() {
    	this.trialCount.getAndIncrement();
    }
    
    public void incrementaInCircleCount() {
    	this.inCircleCount.getAndIncrement();
    }
}
