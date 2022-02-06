package assignment;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sales")
public class Sales {
	
	private int sid;
	
	@Autowired
	@Qualifier("salesperson")
	private PersonDetails salesPerson;
	
	@Autowired
	private Product product;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public PersonDetails getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(PersonDetails salesPerson) {
		this.salesPerson = salesPerson;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Sales [sid=" + sid + ", salesPerson=" + salesPerson + ", product=" + product + "]";
	}

	
	
	
	public void show() {
		setSid(224);
		salesPerson.showPesrsonDetails();
		product.showProduct();	
	}

}
