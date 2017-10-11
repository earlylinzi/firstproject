package com.myutil.duoxiancheng;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
	public static final void second(long second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
