package utils;

public class outBiggerLog {


    public static void main(String[] args) {

        String result = outBiggerLog("{\"car\":\"1098765432\",\"CardsRight\":\"hsiadhfasdjhfkaueoiivhncvhaheiowgaheojdahfajehfiawefjefkjahefhgagh\",\"idNum\":\"130234199378803853\"}");
        System.out.println(result);

    }


    public static String outBiggerLog(String s){


        String[] ss = s.split(",");
        StringBuffer bf = new StringBuffer();
        int len = ss.length;
        for (int i = 0 ; i < len ; i++){
            if(ss[i].length() > 50 ){
                int ll = ss[i].length();
                String s1 = ss[i].substring(0,50);
                String s2 = ss[i].substring(ll-3,ll);
                ss[i] = s1+"..."+s2;
            }
            if(i != 0){
                bf.append(",");
            }
            bf.append(ss[i]);
        }
        return bf.toString();
    }



}
