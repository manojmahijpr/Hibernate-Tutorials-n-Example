package com.Daemons.dto;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Details {

    private int age;
    private String mobile;
    private String branch;

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    public String getBranch() {
	return branch;
    }

    public void setBranch(String branch) {
	this.branch = branch;
    }

}
