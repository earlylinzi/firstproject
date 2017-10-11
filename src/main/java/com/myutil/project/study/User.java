package com.myutil.project.study;

public class User {
    public Integer age;
    private String name;
    public User() {
    	super();
    	System.out.println("父类空参构造");
    }
//    public User(String name) {
//        super();
//        this.name = name;
//    }
    public User(int age, String name) {
    	System.out.println("父类全参构造");
    	this.name = name;
    	this.age = age;
    }
	public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}