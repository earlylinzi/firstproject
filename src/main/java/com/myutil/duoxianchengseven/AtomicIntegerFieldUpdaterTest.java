package com.myutil.duoxianchengseven;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater 这个类能够对某一个实体类某一个原子字段进行操作
 * 对象是某一个的字段（根据以下的代码就 能知道）
 */
public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        User kenan = new User("kenan", 10,10);
        System.out.println(a.getAndIncrement(kenan));
        System.out.println(a.get(kenan));
    }




    static class User{
        private String name;
        public volatile int old;
        public volatile int age;
        public User(String name,int old,int age){
            this.name = name;
            this.old = old;
            this.age = age;
        }
        public String getName(){
            return name;
        }
        public int getOld(){
            return old;
        }
        public int getAge(){
            return age;
        }
    }
}
