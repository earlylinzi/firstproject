package com.myutil.duoxianchengfive;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 通过这么一个缓存示例说明读写锁的使用方式\
 * 本类用了一个非线程安全的hashMap作为缓存的实现，同时使用读写锁来保证了cache是线程安全的
 * 以后如果遇到像  如何控制hashMap是线程安全的  可以用这个作答
 */
public class Cache {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
    static Lock r = rw1.readLock();
    static Lock w = rw1.writeLock();

//  获取一个key对应得value
    public static final Object get(String key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }
    }
//  设置一个key对应的value
    public static final Object put(String key ,Object value){
        w.lock();
        try{
            return map.put(key, value);
        }finally {
            w.unlock();
        }
    }

//   清空所有的内容
    public static final void clear(){
        w.lock();
        try {
            map.clear();
        }finally {
            w.unlock();
        }
    }
}
