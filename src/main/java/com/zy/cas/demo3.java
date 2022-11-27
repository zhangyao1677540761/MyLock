package com.zy.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @学习小结 自旋...
 */
public class demo3 {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(()->{
            myLock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLock.unlock();
        },"T1").start();


    }
}

class MyLock {

    AtomicReference<Thread> AtomicReference = new AtomicReference();


    public void lock() {
        Thread Thread = new Thread();
        while (!AtomicReference.compareAndSet(null, Thread)) {
        }
    }

    public void unlock () {
        java.lang.Thread thread = AtomicReference.get();
        AtomicReference.compareAndSet(thread,null);
    }
}