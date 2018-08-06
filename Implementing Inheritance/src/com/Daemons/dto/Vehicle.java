package com.Daemons.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "VEHICLE_TYPE" , discriminatorType = DiscriminatorType.STRING)
// use @DiscriminatorColumn with SINGLE_TABLE inheritance type
public class Vehicle {

    @Id @GeneratedValue
    private int vehicleId;
    private String vehicleName;
    private String licenseNumber;
    
    public int getVehicleId() {
	return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
	return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
    }

    public String getLicenseNumber() {
	return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
	this.licenseNumber = licenseNumber;
    }
}
