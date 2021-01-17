package com.leetcode.medium;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.



Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.
 *
 * @author：jinsheng
 */
public class PrintFooBarAlternately {

    private int n;

//    private Semaphore semaphoreFoo = new Semaphore(1);
//    private Semaphore semaphoreBar = new Semaphore(0);

    private Lock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private int flag = 1;

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }

//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            semaphoreFoo.acquire();
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            semaphoreBar.release();
//        }
//    }

//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            semaphoreBar.acquire();
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            semaphoreFoo.release();
//        }
//    }
//
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (flag == 0){
                    barCondition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 0;
                fooCondition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (flag == 1){
                    fooCondition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 1;
                barCondition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

}
