package com.myutil.duoxiancheng;

/**
 * 这个类是用来证明通过ThreadLocal能达到在每个线程中创建变量副本
 * 在进行get()方法之前是要进行set()的  否则会报控制针异常
 * 如果重写了initialValue()方法，就不会报空指针异常
 *
 * 最常用的LocalThread 用来解决数据库连接   Session管理等
 * 参考地址：http://www.cnblogs.com/dolphin0520/p/3920407.html
 */
public class ThreadLocalTest {


    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set(){
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return longLocal.get();
    }

    public String getString(){
        return stringLocal.get();
    }

    public static void main(String[] args) throws Exception {
        final ThreadLocalTest test = new ThreadLocalTest();

        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread1 = new Thread(){
            public void run(){
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }
        };

        thread1.start();//启动线程
        thread1.join();//在这个线程结束之后执行

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }



}