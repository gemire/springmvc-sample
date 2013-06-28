package com.dhenton9000.demo.threads;



import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
  public static void main(String args[]) throws Exception{
    ExecutorService es = Executors.newFixedThreadPool(3);
    Future<Double> f = es.submit(new Task1());
    Future<Integer> f2 = es.submit(new Task2());

    System.out.println(f.get());
    System.out.println(f2.get());
    es.shutdown();
  }
}

class Task1 implements Callable<Double> {
  Task1() {
  }

  public Double call() {
    return 0.0;
  }
}
class Task2 implements Callable<Integer> {
  Task2() {
  }

  public Integer call() {
    return 1;
  }
}
