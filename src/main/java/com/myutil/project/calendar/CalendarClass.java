package com.myutil.project.calendar;

import java.util.Calendar;

public class CalendarClass {

	public static void main(String[] args) {
		
		Calendar instanceA = Calendar.getInstance();
		
		instanceA.add(Calendar.HOUR, -1);
		
		System.out.println(instanceA.getTimeInMillis());
		
		Calendar instanceB = Calendar.getInstance();
		
		instanceB.add(Calendar.HOUR, -1);
		
		System.out.println(instanceB.getTimeInMillis());
		
	}
}
