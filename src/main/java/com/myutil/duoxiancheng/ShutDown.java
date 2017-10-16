package com.myutil.duoxiancheng;

import java.util.concurrent.TimeUnit;

/**
 * 这两种通过中断或者标识的操作能够在终止的时候有机会去清理资源而不是武断的将线程停止
 * 这种将线程停止的方式显得更加的优雅
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {

        Runner one  = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        //睡眠一秒  中断线程one  是线程one能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner  two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();

        //  睡眠一秒  使CountThread能够感知on= false 从而结束
        TimeUnit.SECONDS.sleep(1);
        two.concel();

    }

    private static class Runner implements Runnable{
        private long i;
        private volatile static boolean on = true;


        public void run() {
            while(on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("count i = " + i);
        }

        public static void concel(){
            on = false;
        }
    }
}
