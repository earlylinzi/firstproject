package com.myutil.duoxiancheng;

import java.util.ArrayList;
import java.util.List;

public class Priority {
	
	private static volatile boolean notStart = true;
	private static volatile boolean notEnd = true;
	
	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<Job>();
		for (int i = 0; i < 10; i++) {
			int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
			
		}
		
		
	}

	static class Job implements Runnable{
		
		private int priority;
		private long jobCount;
		public Job(int priority){
			this.priority = priority;
		}
		public void run() {
			while(notStart){
				Thread.yield();//暂停当前正在执行的线程对象并执行其他对象
			}
			while(notEnd){
				Thread.yield();
				jobCount++;
			}
		}

	}
}
