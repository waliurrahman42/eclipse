package practice;

public class ProductInventory {
	
	private int pinit;
	private int pquantity;
	private String pcolor;
	
	
	
	
	public ProductInventory() {
		
	}
	
	public ProductInventory(int pinit, int pquantity, String pcolor) {
		super();
		this.pinit = pinit;
		this.pquantity = pquantity;
		this.pcolor = pcolor;
	}
	
	

	public int getPinit() {
		return pinit;
	}
	public void setPinit(int pinit) {
		this.pinit = pinit;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public String getPcolor() {
		return pcolor;
	}
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	@Override
	public String toString() {
		return "ProductInventory [pinit=" + pinit + ", pquantity=" + pquantity + ", pcolor=" + pcolor + "]";
	}
	
}
