package com.myutil.project.urlEncoder;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncoderTest {
	
	
	  public static void main(String[] args)throws Exception
	  {
	   //将application/x-www-form-urlencoded字符串
	   //转换成普通字符串
	   //其中的字符串直接从上图所示窗口复制过来
	   String keyWord = URLDecoder.decode("%E7%BD%91%E7%BB%9C%23%23%24%25%5E%26*%F0%9F%98%80%40%21%E6%97%B6%E7%A9%BA", "UTF-8");
	   System.out.println(keyWord);
	   //将普通字符串转换成
	   //application/x-www-form-urlencoded字符串
	   String urlStr = URLEncoder.encode(
	    "网络##$%^&*😀@!时空" , "UTF-8");
	   System.out.println(urlStr);
	  }

}
