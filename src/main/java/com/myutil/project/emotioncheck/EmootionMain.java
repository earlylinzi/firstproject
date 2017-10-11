package com.myutil.project.emotioncheck;

public class EmootionMain {
	public static void main(String[] args) {
		
//		String string = "��都嗨��、😀齐静��给你��";
		String string = "我,./!@##$$%^&*们hh800";
	    System.out.println(EmotionTest.containsEmoji(string));
	    System.out.println(EmotionTest.filterEmoji(string));
		
		
		
	}

}
