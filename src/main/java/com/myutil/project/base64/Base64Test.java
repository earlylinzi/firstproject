package com.myutil.project.base64;

import sun.misc.BASE64Encoder;
import java.io.IOException;
import sun.misc.BASE64Decoder;

public class Base64Test {
	public static void main(String[] args) {
		String base64 = getBASE64("sss");
		System.out.println(base64);
		String fromBase64 = getFromBase64(base64);
		System.out.println(fromBase64);
	}
	/**
	 * BASE64编码
	 */
	public static String getBASE64(String s){
		if(s == null) return null;
		sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
		String encode = base64Encoder.encode(s.getBytes());
		return encode;
	}
	/**
	 * BASE64解码
	 */
	public static String getFromBase64(String s){
		if(null == s){
			return null;
		}
		BASE64Decoder base64Decoder = new BASE64Decoder();
		try {
			byte[] decodeBuffer = base64Decoder.decodeBuffer(s);
			return new String(decodeBuffer);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
