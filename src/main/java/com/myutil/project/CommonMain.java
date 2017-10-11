package com.myutil.project;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonMain {
	
	/**
	 * 比较两版本的大小
	 * @param clientVersion
	 * @param targerVersion
	 * @return
	 */
	public static int versionCompare(String clientVersion, String targerVersion){
		if(null == clientVersion){
			return -1;
		}
		if(null == targerVersion){
			return 1;
		}
		String cVersion = clientVersion.trim().replace(".","");
		String tVersion = targerVersion.trim().replace(".","");
		int clientlength = cVersion.length();
		int targerLength = tVersion.length();
		int cha = clientlength - targerLength;  
		if(cha > 0){
			tVersion += fillZero(cha);
		}else if(cha < 0){
			cVersion += fillZero(cha);
		}
		return Integer.valueOf(cVersion).compareTo(Integer.valueOf(tVersion));
	}
	
	private static String fillZero(int cha){
		String result = "";
		int i = 0;
		cha = Math.abs(cha);
		while(i< cha){
			result += "0";
			i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
//		int in = versionCompare("4.3.7.1","4.3.7.1");
//		System.out.println(in);
		Integer age = -1;
		if(null != age && -1 != age){
			System.out.println("yes");
		}
		System.out.println("no");
	}
	
	

}
