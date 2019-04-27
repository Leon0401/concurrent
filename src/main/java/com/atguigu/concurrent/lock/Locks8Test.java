package com.atguigu.concurrent.lock;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1 标准访问，请问先打印邮件还是短信？
 * 2 邮件方法里面新增暂停4秒钟的方法，请问先打印邮件还是短信？
 * 3 新增一个普通的sayHello方法，请问先打印邮件还是hello？
 * 4 有两部手机，请问先打印邮件还是短信？
 * 5 两个静态同步方法，同一部手机，请问先打印邮件还是短信？
 * 6 两个静态同步方法，2部手机，请问先打印邮件还是短信？
 * 7 1个静态同步方法，1个普通同步方法,1部手机，请问先打印邮件还是短信？
 * 8 1个静态同步方法，1个普通同步方法,2部手机，请问先打印邮件还是短信？
 *
 *
 * 一种锁只会对被该类型锁修饰的部分起作用，不同的锁之间是没有影响的，也就是说，多种锁是可以并行存在的。
 */
class phone {
     static  {

    }
    public synchronized void sendEmail() {
        System.out.println("......sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("...........sendSMS");
    }

    public void sayHello() {
        System.out.println(".....hello");
    }
}


public class Locks8Test {
    public static void main(String[] args) {
        new CopyOnWriteArrayList<>();

        phone p1 = new phone();

        new Thread(() -> {
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p1.sendEmail();

        }, "A").start();

        new Thread(() -> {

            p1.sendSMS();

        }, "A").start();

        new Thread(() -> {
            p1.sayHello();

        }, "A").start();
    }
}
