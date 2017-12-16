package com.myutil.duoxianchengeight;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 接收一个int值作为一个程序计数器   如果想要n个点执行完成就传入n
 * c.countDown()方法会把n-1 这个方法可以用在任何地方  可以是n个线程  也可以是n个执行步骤
 * c.await()方法会阻塞当前线程直至n变为0
 *
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                c.countDown();
                System.out.println("2");
                c.countDown();
                c.countDown();
                c.countDown();
                c.countDown();
                System.out.println("4");
            }
        }).start();
        c.await();
        System.out.println("3");
    }
}
