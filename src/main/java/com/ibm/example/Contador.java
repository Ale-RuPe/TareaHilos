package com.ibm.example;

import java.util.concurrent.atomic.*;

public class Contador {

  private AtomicInteger cuenta = new AtomicInteger();

  public void incrementaCuenta() {
    this.cuenta.getAndIncrement();
  } 

  public AtomicInteger getCuenta() {
    return this.cuenta;
  }


}
