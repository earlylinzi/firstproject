package com.myutil.project.study;

import java.util.Date;

public class UserDetail extends User{
	
	
	private Integer gender;
	private Date birthday;
	private String address;
	private String telephone;
	public UserDetail(Integer gender, Date birthday, String address, String telephone) {
//		super();
		this(gender,birthday);
		this.address = address;
		this.telephone = telephone;
		System.out.println("子类全参构造");
	}
	public UserDetail(Integer gender, Date birthday) {
		super();
		this.gender = gender;
		this.birthday = birthday;
		System.out.println("子类2参构造");
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

}
