package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	private int jobid;
	private String jobdescription;
	private double salary;
	private String Designation;
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	

}
