package com.myutil.project.gcClass;

public class GCClass {

	private static final int _1MB = 1024* 1024;
	
	public static void testAllocation(){
		
		byte[] allocation,allocation2,allocation3,allocation4;
		allocation = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[2 * _1MB];
		
	}
	
	public static void main(String[] args) {
		testAllocation();
	}
}
