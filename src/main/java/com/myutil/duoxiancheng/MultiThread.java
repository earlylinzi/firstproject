package com.myutil.duoxiancheng;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
	public static void main(String[] args) {
		//获取java线程管理MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//		不需要获取同步的monitor和synchronizer信息，仅获取线程和线程的堆栈信息
		ThreadInfo[] threads = threadMXBean.dumpAllThreads(false, false);
//		遍历线程信息仅打印线程 id和线程名称信息
		for (ThreadInfo threadInfo : threads) {
			System.out.println(threadInfo.getThreadId()+"   "+threadInfo.getThreadName());
			
		}
		
		
		
	}

}
