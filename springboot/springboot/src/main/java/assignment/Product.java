package assignment;

import org.springframework.stereotype.Component;

@Component
public class Product {
	
	private int pid;
	private String pname;
	private double price;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	public void showProduct() {
		setPid(11);
		setPname("laptop");
		setPrice(50000);
	}
	
	
}
