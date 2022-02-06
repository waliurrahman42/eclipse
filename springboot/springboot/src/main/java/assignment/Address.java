package assignment;

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	private int streetNo;
	private String city;
	private String State;
	
	
	public int getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	

	public String toString() {
		return "Address[streetNo=" +streetNo +", city = "+city+", State = "+ State +"]";
	}
	

	
}
