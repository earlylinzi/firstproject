package com.shejimoshi.gongchang;

/**
 * 工厂类角色
 */
public class Driver {

    public static Car driveCar(String s) throws Exception{
        if(s.equalsIgnoreCase("Benz")){
            return new Benz();
        }else if(s.equalsIgnoreCase("Bmw")){
            return new Bmw();
        }else if(s.equalsIgnoreCase("Audi")){
            return new Audi();
        }else{
            throw new Exception();
        }


    }

    // 这还是真的老司机老司机老司机老司机



}
