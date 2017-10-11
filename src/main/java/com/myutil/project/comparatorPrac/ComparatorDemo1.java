package com.myutil.project.comparatorPrac;

import java.util.Comparator;

import com.myutil.project.domain.Apple;

public class ComparatorDemo1 implements Comparator<Apple>{

	public int compare(Apple o1, Apple o2) {
		// TODO Auto-generated method stub
		if(o1.getWeight() > o2.getWeight()){
			return 1;
		}else if(o1.getWeight() == o2.getWeight()){
			return 0;
		}else{
			return -1;
		}
	}


}
