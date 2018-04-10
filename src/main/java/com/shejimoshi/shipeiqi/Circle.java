package com.shejimoshi.shipeiqi;

/**
 *  需要改造的适配器类
 *  圆形是需要实现的图形  发现已经 有了圆形的实现了
 *  如果改变现有的图形实现的话  将会有很大的改动   况且java是单继承的
 *  这时候就需要用适配器模式
 */
public class Circle extends Shape{

    private TextCircle textCircle;
    //在构造的时候为   成员变量（也就是需要适配的对象）先实例化
    public Circle(){
        textCircle = new TextCircle();
    }
    public void dispaly(){
        textCircle.displayIt();
    }
}
