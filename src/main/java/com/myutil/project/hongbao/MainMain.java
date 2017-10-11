package com.myutil.project.hongbao;

import java.util.HashMap;
import java.util.Map;

public class MainMain {
	public static void main(String[] args) {
		
		
//	 long sqrt = (long)Math.sqrt(80);  
//		System.out.println(sqrt);
//		
		
		Map<String,Integer>  m = new HashMap<String,Integer>();
		Map<String,Integer>  mm = new HashMap<String,Integer>();
		m.put("a", 1);
		mm.put("a", 2);
		m.putAll(mm);
		System.out.println(m.get("a"));
		
		
//		Random random = new Random();  
//        random.setSeed(100000);  
//        for (int i = 0; i < 10; i++) {
//        	System.out.println(random.nextInt(5));			
//		}
		
	}
}
