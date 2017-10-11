package com.myutil.project.comparatorPrac;

import java.util.ArrayList;
import java.util.Collections;

import com.myutil.project.domain.Apple;

public class ComparatorTest {

	public static void main(String[] args) {
		
		ArrayList<Apple> arrayList = new ArrayList<Apple>();
		
		arrayList.add(new Apple(4.3D,4));
		arrayList.add(new Apple(3.3D,1));
		arrayList.add(new Apple(5.3D,6));
		arrayList.add(new Apple(2.3D,3));
		arrayList.add(new Apple(7.3D,9));
		
		 Collections.sort(arrayList, new ComparatorDemo1());
		
		 for (Apple apple : arrayList) {
			System.out.println(apple.getWeight());
		}		
		
		
	}
}
