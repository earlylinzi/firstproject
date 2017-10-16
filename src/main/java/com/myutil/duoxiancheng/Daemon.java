package com.myutil.duoxiancheng;

import com.myutil.duoxiancheng.SleepUtils;

public class Daemon {

    public static void main(String[] args) {

        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
    //在构建Daemon线程的时候  不能依靠finally  块中的内容来确保执行清理或者释放资源的逻辑
    static class DaemonRunner implements Runnable{

        public void run() {
            try {
                SleepUtils.second(10);
            }finally {
                System.out.println("do  it");
            }
        }
    }



}
