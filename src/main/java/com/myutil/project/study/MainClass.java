package com.myutil.project.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;
import java.util.Scanner;

import com.sfbest.message.sms.entity.MsgNotes;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
		
//		test06();
	
		Random random = new Random();
		
		System.out.println("请输入第一个数据");		
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		System.out.println("您输入的参数是："+ i);
		
		
		
		
	}
	
	
	private static int gongyueshu(int x ,int y){
		if(x<y){
			int t = x;
			x=y;
			y=t;
		}
		while(y != 0){
			if(x == y)return x;
			else{
				int k = x%y;
				x=y;
				y=k;
			}
		}
		return x;
	}
	
	
	
	
	
	/**
	 * 通过反射机制
	 */
	/**
	 * 获取某个类的全部方法
	 */
	public static void test06() throws Exception{

		Class<?> clazz = Class.forName("com.myutil.project.study.UserDetail");
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Class<?> returnType = methods[i].getReturnType();
			Class<?>[] paras = methods[i].getParameterTypes();
			int mo = methods[i].getModifiers();
			System.out.print(Modifier.toString(mo)+"  ");
			System.out.print(returnType.getName()+"  ");
			System.out.print(methods[i].getName()+"  ");
			System.out.print("(");
			 for (int j = 0; j < paras.length; ++j) {
	                System.out.print(paras[j].getName() + " " + "arg" + j);
	                if (j < paras.length - 1) {
	                    System.out.print(",");
	                }
	            }
			Class<?>[] exce = methods[i].getExceptionTypes();
			 if (exce.length > 0) {
	                System.out.print(") throws ");
	                for (int k = 0; k < exce.length; ++k) {
	                    System.out.print(exce[k].getName() + " ");
	                    if (k < exce.length - 1) {
	                        System.out.print(",");
	                    }
	                }
	            } else {
	                System.out.print(")");
	            }
	            System.out.println();
			
			
			
		}
	}
	
	
	
	
	/**
	 * 获取某个类的全部属性
	 * @throws Exception
	 */
	public static void test05() throws Exception{
		
		Class<?> clazz = Class.forName("com.myutil.project.study.UserDetail");
		System.out.println("=====本类属性=====");
		//获取本类的全部属性
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			//权限修饰符
			int mo = fields[i].getModifiers();
			String prio = Modifier.toString(mo);
			//属性类型
			Class<?> type = fields[i].getType();
			System.out.println(prio+" "+type.getName()+" "+fields[i].getName()+";");
			
		}
		
		System.out.println("======实现的接口或者父类的属性=============");
		//取得实现的接口或者父类的属性  此时只能获取到public修饰的属性其他的获取不到
		Field[] fieldss = clazz.getFields();
		for (int i = 0; i < fieldss.length; i++) {
			//权限修饰符
			int mo = fieldss[i].getModifiers();
			String prio = Modifier.toString(mo);
			//属性类型
			Class<?> type = fieldss[i].getType();
			System.out.println(prio+" "+type.getName()+" "+fieldss[i].getName()+";");
			
		}
		
	}
	/**
	 * 通过某个类的全部构造函数  通过反射机制实例化一个类的对象
	 * @throws Exception
	 */
	public static void test04() throws Exception{
		
		Class<?> class1 = null;
		class1 = Class.forName("com.myutil.project.study.User");
		
		//第一种: 实例化默认构造方法  调用set方法
		User user = (User)class1.newInstance();
		user.setAge(20);
		user.setName("liutoa");
		System.out.println(user);
		
		//第二种方法  取得全部的构造函数  使用构造函数赋值
		Constructor<?>[] cons = class1.getConstructors();
		//查看每个构造方法需要的参数
		for (int i = 0; i < cons.length; i++) {
			Class<?>[]  clazzs = cons[i].getParameterTypes();
			System.out.print("cons["+i+"] (");
			for (int j = 0; j < clazzs.length; j++) {
				if(j == clazzs.length - 1){
					System.out.print(clazzs[j].getName());
				}else{
				System.out.print(clazzs[j].getName()+",");
				}
			}
			System.out.println(")");
			
		}
		
		user = (User)cons[2].newInstance("Rollen");
		System.out.println(user);
		
		user = (User)cons[1].newInstance(20,"Shiro");
		System.out.println(user);
		
		
	}
	/**
	 * 获取一个对象的父类和接口
	 * @throws ClassNotFoundException
	 */
	public static void test03() throws Exception{
		Class<?> clazz = Class.forName("com.sfbest.message.sms.entity.MsgNotes");
		
		Class<?> superclass = clazz.getSuperclass();
		System.out.println("父类:"+superclass.getName());
		
		Class<?>[] interfaces = superclass.getInterfaces();
		System.out.println("实现的接口有:");
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println(interfaces[i].getName());
		}
	}
	/**
	 * 实例化对象
	 * @throws ClassNotFoundException
	 */
	public static void test02() throws ClassNotFoundException{
		
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		class1 = Class.forName("com.sfbest.message.sms.entity.MsgNotes");
		class2 = new MsgNotes().getClass();
		class3 = MsgNotes.class;
		System.out.println("类全名:"+class1.getName());
		System.out.println("类全名:"+class2.getName());
		System.out.println("类全名:"+class3.getName());
		
	}
	/**
	 * 获取一个对象的完整的类名和包名
	 */
	public static void test01(){
		MsgNotes msgNotes = new MsgNotes();
		System.out.println(msgNotes.getClass().getName());
	}
}










