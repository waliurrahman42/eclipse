package constructor.bean.collection.spring;

public class CustomerAddress {
		
	private int addressId;
	private String address;
	private String pinCode;
	
	public CustomerAddress() {
		
	}
	
	public CustomerAddress(int addressId, String address, String pinCode) {
		this.addressId = addressId;
		this.address = address;
		this.pinCode = pinCode;
	}
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
}
