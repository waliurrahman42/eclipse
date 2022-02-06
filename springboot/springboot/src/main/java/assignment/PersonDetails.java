package assignment;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("salesperson")
public class PersonDetails {
	
	private String name;
	private String email;
	private String Contact;
	
	@Autowired(required = true)
	private Address address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void personDetail() {
		
	}
	
	public String toString() {
		return "salesperson[name=" + name + ", email = "  + email + "Contact ="+ Contact + "address=" +address+"]";
	}
	
	
	public void showPesrsonDetails() {
		setName("waliur rahman");
		setEmail("waliur42@gmail.com");
		setContact("9572950888");
		address.setCity("patna");
		address.setState("bihar");
		address.setStreetNo(52);
		
	}
	
	
	
	
}
