package com.Daemons.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue
    private int userId;
    @Column(name = "User_Name")
    private String userName;

    @Embedded
    @AttributeOverrides({ 
	@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
	@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
	@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")),
	@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE")) })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({ 
	@AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
	@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
	@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
	@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE")) })
    private Address officeAddress;

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public Address getHomeAddress() {
	return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
	this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
	return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
	this.officeAddress = officeAddress;
    }

}
