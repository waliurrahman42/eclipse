package com.test.Assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;



@Entity
public class Company {
	@Id
	@Column(name="cid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	
	@Column(name="cname")
	private String compName;
	private String compCategory;
	
	public Company () {
		
	}
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompCategory() {
		return compCategory;
	}
	public void setCompCategory(String compCategory) {
		this.compCategory = compCategory;
	}
	
	

}
