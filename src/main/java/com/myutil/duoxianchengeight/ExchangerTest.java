package com.myutil.duoxianchengeight;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger 是一个用于线程间协作的工具类  用于线程间的数据交换
 * 它提供一个同步点  在这个同步点  两个线程可以交换彼此的数据
 *
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args){
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水A";
                    String A = exgr.exchange(B);
                    System.out.println("A和B数据是否一致:"+ A.equals(B) + ",A录入的是："+A+",B录入的是："+B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }


}
