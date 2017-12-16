package com.myutil.duoxianchengseven;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("hanshuai",18);
        atomicUserRef.set(user);
        User updateUser = new User("early", 19);
        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
        System.out.println(user.getOld());
        System.out.println(user.getName());
    }







    static class User{
        private String name;
        private int old;
        public User(String name,int old){
            this.name = name;
            this.old = old;
        }
        public String getName(){
            return name;
        }
        public int getOld(){
            return old;
        }
    }
}
