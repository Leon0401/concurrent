package com.atguigu.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * * 实现一个线程对该变量加1，一个线程对该变量减1，
 * * 实现交替，来10轮，变量初始值为零。
 * <p>
 * 多线程模板：
 * 1、高内聚低耦合的前提下，线程操纵资源类
 * 2、判断、干活、通知，
 * 3、多线程编程时需要注意，防止多线程的虚假唤醒，多线程的判断不能使用if，要使用while。
 *  3.5   标志位
 *
 * synchronized与lock单纯做锁时没有区别。
 */
class AirConditioner {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

/*    public synchronized void increase() throws Exception {

        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);

        this.notifyAll();

    }

    public synchronized void decrease() throws Exception {

        if (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);

        this.notifyAll();

    }*/

    public void increase() throws Exception {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() throws Exception {
        lock.lock();
        try {
            if (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


public class ProdConsumerTest {
    public static void main(String[] args) {

        AirConditioner conditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    conditioner.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    conditioner.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    conditioner.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    conditioner.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

    }
}
