package com.shejimoshi.gongchang;

public class Magnate {
    public static void main(String[] args) {

        try {
            Car car = Driver.driveCar("Bmw");
            car.drive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
