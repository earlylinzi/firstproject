package com.myutil.duoxianchengsix;

import java.util.HashMap;
import java.util.UUID;

/**
 * 这个是为了证明HashMap在并发的情况下是线程不安全的
 *
 * result :Exception in thread "ftf" java.lang.OutOfMemoryError:
 */
public class HashMapTest {
    final static HashMap<String ,String> map = new HashMap();
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i < 10 ;i ++){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    },"ftf"+i).start();
                }
            }
        },"ftf");


        t.start();
        t.join();
        System.out.println("ok");
    }
}
