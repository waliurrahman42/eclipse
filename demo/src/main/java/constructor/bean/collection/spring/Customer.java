package constructor.bean.collection.spring;

import java.util.List;

public class Customer {
	
	private int cid;
	private String customerName;
	private List<CustomerAddress> custAdd;
	
	public Customer() {
		
	}
	
	public Customer(int cid, String customerName, List<CustomerAddress> custAdd) {
		this.cid = cid;
		this.customerName = customerName;
		this.custAdd = custAdd;
	}


	public String getCustomerName() {
		return customerName;
	}


	public List<CustomerAddress> getCustAdd() {
		return custAdd;
	}





	public int getCid() {
		return cid;
	}


	public void details(){
		System.out.println("customer name is "+customerName);
		System.out.println("address is");
		for(CustomerAddress add:custAdd) {
			System.out.println(add);
		}
	}
}
