package com.myutil.duoxiancheng;

import java.util.concurrent.TimeUnit;

import com.myutil.duoxiancheng.SleepUtils;

public class Interrupted {
    public static void main(String[] args) throws Exception {
        // sleepThread 不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"sleepThread");
        sleepThread.setDaemon(true);

        // busyThread 不停的尝试睡眠
        Thread busyThread = new Thread(new BusyRunner(),"busyThread");
        busyThread.setDaemon(true);

        //启动这两个线程
        sleepThread.start();
        busyThread.start();

        // 休息5秒 让这两个线程充分运行
        TimeUnit.SECONDS.sleep(5);

        // 对这两个线程进行中断操作
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread的中断属性："+sleepThread.isInterrupted());
        System.out.println("busyThread的中断属性："+busyThread.isInterrupted());

        //防止这俩线程立即退出
        TimeUnit.SECONDS.sleep(2);
    }

    //一直处于沉睡的线程
    static class SleepRunner implements Runnable{
        public void run(){
            while (true){
                SleepUtils.second(10);
            }
        }
    }
    //一直处于忙碌的线程
    static class BusyRunner implements Runnable{
        public void run(){
            while (true){

            }
        }

    }
}
