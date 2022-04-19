package seter.method.bean.spring;

import java.util.Map;

public class MyProductInventery {
		
	private int invId;
	private int invQuant;
	
	private Map<MyProduct,Lead> item;
	
	
	
	
	
	public Map<MyProduct, Lead> getItem() {
		return item;
	}
	public void setItem(Map<MyProduct, Lead> item) {
		this.item = item;
	}
	
	
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
	}
	public int getInvQuant() {
		return invQuant;
	}
	public void setInvQuant(int invQuant) {
		this.invQuant = invQuant;
	}
	
	@Override
	public String toString() {
		return "MyProductInventery [invId=" + invId + ", invQuant=" + invQuant + "]";
	}
	
	
}
