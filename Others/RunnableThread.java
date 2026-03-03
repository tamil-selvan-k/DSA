// import java.util.*;
import java.lang.Thread;


class MyThread implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Thread is running: " + Thread.currentThread().getName());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class RunnableThread {
  public static void main(String[] args) {
    // Scanner get = new Scanner(System.in);
    MyThread runnable = new MyThread();
    
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    Thread t3 = new Thread(runnable);


    t1.start();
    t2.start();
    t3.start();
  }
}
