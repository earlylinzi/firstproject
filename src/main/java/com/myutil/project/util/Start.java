package com.myutil.project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Start {

	public static void main(String[] args) throws Exception {
		
//		

		
		System.out.println(stringDateToInt("2017年09月18日","yyyy年MM月dd日"));
		
//		System.out.println("4.3.9">"4.3.8");
		//-----------------------
		
//		try {
//			List<MsgNotes> msgNotes = new ExcelReader().readExcekContent(new FileInputStream("E:/666.xls"));
//			System.out.println(msgNotes.size());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		///----------------------------------
		
//		try {
//			String[] readTile = new ExcelReader().readTile(new FileInputStream("E:/666.xls"));
//			for (int i = 0; i < readTile.length; i++) {
//				System.out.println(readTile[i]);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
	}
	
public static Integer stringDateToInt(String strDate,String format) throws ParseException{
		
		if(null == format || "".equals(format.trim())){
			return null;
		}
		SimpleDateFormat f =  new SimpleDateFormat(format);
		Date date = f.parse(strDate);
		return (int)(date.getTime()/1000);
	}
	
	
public static String intDateToString(int intDate,String format){
		
		SimpleDateFormat f =  new SimpleDateFormat(format);  
		
	    String d = f.format(Long.parseLong(String.valueOf(intDate).concat("000"))); 
		return d;
	}
	
	
	
	
}
