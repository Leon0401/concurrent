package com.stark.concurrent.saleticket;

public class SaleTickets implements Runnable
{
    private int ticketCount = 30;
    Object mutex = new Object();

    /**
     * 卖票
     */
    public void sellTicket()
    {
        synchronized (mutex)

        {
            if (ticketCount > 0)
            {

                System.out.println(Thread.currentThread().getName()
                        + "正在卖票,还剩" + ticketCount + "张票");
                ticketCount--;
            }
            else
            {
                System.out.println("票已经卖完！");
                return;
            }
        }
    }

    @Override
    public void run()
    {
        while (ticketCount > 0)
        {
            sellTicket();
            if (ticketCount==0){
                System.out.println("卖完了");
            }
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}