package com.shejimoshi.singleton;

/**
 * 单例模式之饿汉式
 * 特点是  在类初始化的时候就已经初始了一个实例
 */
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }


}
