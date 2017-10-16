package com.myutil.duoxiancheng;


public class ThreadState {

    public static void main(String[] args) {

        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
        // 使用两个Blocked线程   一个获取线程  另一个被阻塞
        new Thread(new Blocked(),"Blocked1").start();
        new Thread(new Blocked(),"Blocked2").start();


    }

//    该线程不断地进行睡眠
    static class TimeWaiting implements Runnable{

		public void run() {
			 while(true){
	                SleepUtils.second(10);
	            }
		}

    }

//    该线程在Waiting.class实例上等待
    static class Waiting implements Runnable{

        
        public void run() {
            while(true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

//    该线程在Blocked.class实例上加锁后不会释放该锁
    static class Blocked implements Runnable{

        public void run() {
            while(true) {
                synchronized (Blocked.class) {
                    SleepUtils.second(10);
                }

            }
        }
    }

}
