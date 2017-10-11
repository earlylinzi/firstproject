package com.myutil.project.domain;

public class Apple {
	private int num;//数量
	private Double weight;//重量\
	public Apple(Double weight,int num){
		this.weight = weight;
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	

}
