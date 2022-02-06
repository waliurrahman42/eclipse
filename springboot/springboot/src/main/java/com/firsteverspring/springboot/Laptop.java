package com.firsteverspring.springboot;

import org.springframework.stereotype.Component;

@Component("lappy")
public class Laptop {
	
	private int lid;
	private String lcompany;
	
	
	public int getLid() {
		return lid;
	}
	
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLcompony() {
		return lcompany;
	}
	public void setLcompony(String lcompony) {
		this.lcompany = lcompany;
	}
	
	@Override
	public String toString() {
		return "Laptop[lid=" + lid + ", lcompany = "  + lcompany + "]";
	}
	
	public void execute() {
		System.out.println("it is running...");
	}

}
