package com.myutil.practice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestPrivateStatic {

    public static final String A ;
    static{
        A = "ttttt";
    }

    private static final Map<String, String[]> MENGWANG_CONFIGURATION = new HashMap(){{
        put("2", new String[]{"http://TSCM2.800CT.COM:9003/MWGate/wmgw.asmx/MongateCsSpSendSmsNew", "J01306", "331002"});	//原来的渠道
        put("3", new String[]{"http://TSC10.800CT.COM:8016/MWGate/wmgw.asmx/MongateCsSpSendSmsNew", "JA0283", "255441"}); //新增的渠道
        put("5", new String[]{"http://TSC2.800CT.COM:8892/MWGate/wmgw.asmx/MongateCsSpSendSmsNew", "JH2183", "126943"}); //新增的渠道
    }};

    public static void main(String[] args) {

//       String s = "源{}9;检测{|}美国{}4;检测{}提高{|}";
//        String[] split = s.split("\\{\\|\\}");
//        System.out.println(split[1]);



    }
    public static int getSecondTimestamp(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }

}
