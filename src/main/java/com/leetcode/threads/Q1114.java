package com.leetcode.threads;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo_S1 {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public Foo_S1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (atomicInteger.get() != 0) {

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomicInteger.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomicInteger.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        atomicInteger.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomicInteger.get() != 2) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        atomicInteger.incrementAndGet();
    }


}

class Foo_S2 {
    int num;
    Lock lock;
    Condition condition1;
    Condition condition2;
    Condition condition3;

    public Foo_S2() {
        num = 1;
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();
    }


    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (num!=2) {
                condition2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num=3;
            condition3.signal();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (num !=3) {
                condition3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}