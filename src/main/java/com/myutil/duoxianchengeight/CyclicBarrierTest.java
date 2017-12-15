package com.myutil.duoxianchengeight;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 构造方法中的int指的是屏障拦截的线程数
 * 每个线程调用await()方法告诉CyclicBarrier 我已经到达屏障
 * 然后当前的线程被阻塞   直到到达的线程数  达到构造的线程数量的时候就会继续执行
 */
public class CyclicBarrierTest {
    static CyclicBarrier cy = new CyclicBarrier(2);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cy.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        cy.await();
        System.out.println(2);
    }
}
