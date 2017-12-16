package com.myutil.duoxianchengeight;

/**
 * 通过join方法  解决平时  多个线程全部完成后才算都完成的逻辑
 */
public class JoinCountDownLatch {
    public static void main(String[] args) throws InterruptedException {

        Thread parse1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parse1--finished");
            }
        });
        Thread parse2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parse2--finished");
            }
        });

        parse1.start();
        parse2.start();
        parse1.join();
        parse2.join();

        System.out.println("all--finished");
    }
}
