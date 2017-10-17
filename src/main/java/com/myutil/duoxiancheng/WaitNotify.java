package com.myutil.duoxiancheng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {

	static boolean flag = true;
	static Object lock = new Object();
	public static void main(String[] args) throws Exception {
		Thread waitThread = new Thread(new Wait(),"WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread notifyThread = new Thread(new Notify(),"notifyThread");
		notifyThread.start();
	}
	/**
	 * Thread[WaitThread,5,main] flag is true.wait@ 15:41:31
		Thread[notifyThread,5,main] hold lock. notify @ 15:41:32
		Thread[WaitThread,5,main] flag is false.running@ 15:41:37
		Thread[notifyThread,5,main] hold lock again. sleep @ 15:41:37
	 *
	 */
	
	
	
	static class Wait implements Runnable{

		public void run() {
			// 加锁，拥有lock的Monitor
			synchronized(lock){
				//条件不满足时 继续wait 同时释放了lock的锁 
				while(flag){
					try {
						System.out.println(Thread.currentThread() + " flag is true.wait@ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 条件满足时  完成工作
				System.out.println(Thread.currentThread() + " flag is false.running@ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
			
		}
		
	}
	static class Notify implements Runnable{

		public void run() {
			// 加锁  拥有lock的monitor
			synchronized(lock){
				// 获取lock的锁  然后进行通知  通知的时候不会释放lock的锁
				// 直到当前线程释放了lock后  waitThread才能从wait()方法中返回
				System.out.println(Thread.currentThread() + " hold lock. notify @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();//如果不设置这一步的话Wait线程将一直处于等待状态
				flag = false;
				SleepUtils.second(5);
			}
			
			// 再次加锁
			synchronized(lock){
				System.out.println(Thread.currentThread() + " hold lock again. sleep @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.second(5);
			}
			
		}
		
	}
}
