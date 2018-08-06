package com.Application.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//Positional //@NamedQuery(name = "UserDetails.byId", query = "from User where id = ?")
//@NamedQuery(name = "UserDetails.byId", query = "from User where id = :id")
/*
 @NamedQueries(value = { 
	@NamedQuery(name = "PosUser.byId", query = "from User where id = ?"),
	@NamedQuery(name = "NamedUser.byId", query = "from User where id = :id"),
})*/
@NamedQueries({
    @NamedQuery(name = "PosUser.byId", query = "from User where id = ?"),
    @NamedQuery(name = "NamedUser.byId", query = "from User where id = :id"),
})

//  using Native Sql Query Now I will use table name here which  is USER_CRUD

//@NamedNativeQuery(name = "UserDetails.byId", query = "from USER_CRUD where id = ?")
//@NamedNativeQuery(name = "UserDetails.byId", query = "from USER_CRUD where id = :id")

@NamedNativeQueries({
    
    @NamedNativeQuery(name = "PosUserNative.byId", query = "Select * from USER_CRUD where id = ?" , resultClass = User.class),
    @NamedNativeQuery(name = "NamedUserNative.byId", query = "Select * from USER_CRUD where id = :id" , resultClass = User.class),
})

@Table(name = "USER_CRUD")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
    
    public String toString() {
	
	return "Id: " + this.id + " , Name: " + this.name ;
    }

}
