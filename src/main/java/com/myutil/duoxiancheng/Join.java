package com.myutil.duoxiancheng;

/**
 * 在线程A中执行threadB.join();
 * 意义就表示线程A要等到线程B执行完之后再去执行
 */
public class Join {
	public static void main(String[] args) {
		// 获取当前的线程 也就是main线程
		Thread previous = Thread.currentThread();
		for(int i = 0 ; i < 10 ; i++){
			// 每一个线程拥有前一个线程的引用，需要等待前一个线程的终止才能从join（）方法中返回
			Thread thread = new Thread(new Domino(previous),String.valueOf(i));
			thread.start();
			previous = thread;
		}
		
		
	}
	// 构建一个线程 在其注入线程结束之后执行
	static class Domino implements Runnable{
		private Thread thread;
		Domino(Thread thread){
			this.thread = thread;
		}
		public void run() {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" terminate.");
		}
		
	}

}
