package com.atguigu.concurrent.saleticket;

/**
 * 单独卖票。不形成并发。
 */
public class ThreadTest {
    public static void main(String[] args) {

        Thread t1 = new Thread("ww");
        Thread t2 = new Thread("xz");
        Thread t3 = new Thread("zs");
        t1.start();

        t2.start();

        t3.start();

        for (int i = 0; i < 30; i++) {

            System.out.println(t1.getClass().getName()+"卖出" + i+"张票");

            System.out.println(t2.getClass().getName()+"卖出" + i+"张票");

            System.out.println(t3.getClass().getName()+"卖出" + i+"张票");
        }
        t1.stop();
        t2.stop();
        t3.stop();
    }
}
