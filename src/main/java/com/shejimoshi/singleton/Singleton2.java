package com.shejimoshi.singleton;

/**
 * 单例模式之 懒汉式
 *  特点是 ： 当调用getInstance()方法的时候才去创建实例
 *           并且该方法是sychronized修饰的会比较慢
 *
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
