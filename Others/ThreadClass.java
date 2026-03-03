// import java.util.*;
import java.lang.Thread;


class MyThread extends Thread {
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

public class ThreadClass {
  public static void main(String[] args) {
    // Scanner get = new Scanner(System.in);
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();
    MyThread t3 = new MyThread();

    t1.start();
    t2.start();
    t3.start();
  }
}
