package com.myutil.duoxianchengeight;

/**
 * 线程的join方法  是让当前线程(main)线程   等待join的线程执行完成后  再执行
 * （其实现原理是不停检查join线程是否存活，如果存活的话就让当前线程永远等待下去）
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser1 is finished");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 is finished");
            }
        });
        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();

        System.out.println("all is finished");

    }
}
