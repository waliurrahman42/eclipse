package com.firsteverspring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	
	private int empId;
	private String empName;
	private String epDept;
	
	@Autowired(required = true)
	@Qualifier("lappy")
	private Laptop laptop;
	
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEpDept() {
		return epDept;
	}
	public void setEpDept(String epDept) {
		this.epDept = epDept;
	}
	
	public void show() {
		System.out.println("show function");
		laptop.execute();
	}

}
