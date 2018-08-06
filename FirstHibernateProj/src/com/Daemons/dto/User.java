package com.Daemons.dto;

import javax.persistence.Access;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Users")
public class User {

    @Id
    private int id;
    private String name;
    private Details details;

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

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
