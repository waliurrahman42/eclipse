package practice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sales")
public class Sales {
	
	private int sid;
	private String Salename;
	private Product product;
	

	public Sales() {
	}

	public Sales(int sid, String salename) {
		this.sid = sid;
		this.Salename = salename;
		
	}
	
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSalename() {
		return Salename;
	}

	public void setSalename(String salename) {
		Salename = salename;
	}
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	
	

	@Override
	public String toString() {
		return "Sales [sid=" + sid + ", Salename=" + Salename + ", product=" + product + "]";
	}


	public void show() {
		System.out.println("sales excuted");
		System.out.println(product.toString());
	}

}
