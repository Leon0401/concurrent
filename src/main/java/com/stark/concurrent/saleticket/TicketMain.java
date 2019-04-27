package com.stark.concurrent.saleticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther lenovo
 * <p>
 * 题目：三个售票员         卖出          30张票
 * 如何编写企业级的多线程程序的模板+讨论
 * <p>
 * 1） implements Runnable
 * 2)  匿名内部类
 * 3)  Lambda Express
 * <p>
 * 1 在高内聚低耦合的前提下，线程       操作(某一个具体的业务方法，实例方法)        资源类
 */
class Ticket {
    private int number = 30;


    //ReentrantLock 可重入锁，锁可以重复利用

    private Lock l = new ReentrantLock();

    public void sale() {
        l.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "正在卖第 " + number + " 张票" + "还剩：" + --number + "张票");
            }
        } finally {
            l.unlock();
        }
    }
}


public class TicketMain {

    public static void main(String[] args) {
        final Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "C").start();


        /*for (int i = 1; i <= 30; i++) {
            new Thread(new Runnable() {
                public void run() {
                    ticket.sale();
                }
            }, "A").start();

            new Thread(new Runnable() {
                public void run() {
                    ticket.sale();
                }
            }, "B").start();

            new Thread(new Runnable() {
                public void run() {
                    ticket.sale();
                }
            }, "C").start();
        }*/



        /*SaleTickets runTicekt = new SaleTickets();
        Thread th1 = new Thread(runTicekt, "zs");
        Thread th2 = new Thread(runTicekt, "ls");
        Thread th3 = new Thread(runTicekt, "ww");
        th1.start();
        th2.start();
        th3.start();


        
        th1.stop();
        th2.stop();
        th3.stop();*/

    }

}