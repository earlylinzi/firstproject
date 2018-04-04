package com.shejimoshi.gongchang;

/**
 * 工厂类中扮演着具体产品的角色
 */
public class Benz implements Car{

    @Override
    public void drive() {
        System.out.println("Drive Benz");
    }
}
