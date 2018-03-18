package utils;

import java.util.*;

public class myStringSplit {


    public static void main(String[] args) {

        String s = "纳什{|}西部{|}4;餐厅{|}照片{|}3;fig{|}system{|}3;来源{|}西部{|}8;来源{|}照片{|}4;地点{|}西部{|}3;地点{|}照片{|}6;地点{|}来源{|}9;control{|}system{|}3;control{|}fig{|}4;美国{|}创业{|}8;美国{|}西部{|}10;美国{|}照片{|}8;美国{|}长江{|}5;美国{|}餐厅{|}3;美国{|}来源{|}47;美国{|}地点{|}15;提高{|}创业{|}3;提高{|}西部{|}7;提高{|}照片{|}10;提高{|}长江{|}5;提高{|}餐厅{|}3;提高{|}fig{|}4;提高{|}来源{|}43;提高{|}地点{|}13;提高{|}control{|}3;提高{|}美国{|}69;阶段{|}创业{|}3;阶段{|}西部{|}6;阶段{|}照片{|}6;阶段{|}长江{|}4;阶段{|}来源{|}16;阶段{|}地点{|}3;阶段{|}美国{|}34;阶段{|}提高{|}39;事物{|}美国{|}5;检测{|}来源{|}9;检测{|}美国{|}4;检测{|}提高{|}14;检测{|}阶段{|}3;词汇{|}来源{|}8;词汇{|}美国{|}10;词汇{|}提高{|}9;词汇{|}阶段{|}4;测量{|}照片{|}3;测量{|}来源{|}3;测量{|}美国{|}8;测量{|}提高{|}4;people{|}来源{|}7;people{|}地点{|}3;people{|}美国{|}5;people{|}提高{|}3;people{|}词汇{|}3;判断{|}来源{|}13;判断{|}地点{|}8;判断{|}美国{|}12;判断{|}提高{|}31;判断{|}阶段{|}10;判断{|}检测{|}6;判断{|}词汇{|}4;判断{|}测量{|}3;判断{|}people{|}4;科比{|}纳什{|}5;study{|}来源{|}3;study{|}美国{|}3;study{|}people{|}5;study{|}判断{|}3;成功{|}创业{|}13;成功{|}照片{|}4;成功{|}长江{|}4;成功{|}餐厅{|}4;成功{|}fig{|}3;成功{|}来源{|}25;成功{|}地点{|}11;成功{|}美国{|}65;成功{|}提高{|}54;成功{|}阶段{|}40;成功{|}事物{|}5;成功{|}检测{|}3;成功{|}词汇{|}4;成功{|}判断{|}15";

        String[] strArr1 = s.split(";");



        Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();



        for (int i = 0; i < strArr1.length; i++) {

            String s1 = strArr1[i];


            String[] arr2 = s1.split("\\{\\|"+"}");

            String keyStr = arr2[0];

            if(map.keySet().contains(keyStr)){
                map.get(keyStr).add(s1);

            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(s1);
                map.put(keyStr,list);
            }

        }

        Set set = map.keySet();
        for (int i = 0; i < set.size(); i++) {
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                String ss = (String)iterator.next();
                ArrayList<String> strings = map.get(ss);
                for (int j = 0; j < strings.size(); j++) {

                    System.out.println(strings.get(j));

                }

            }
        }


    }



}
