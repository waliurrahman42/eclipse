package seter.method.bean.spring;

public class MyProduct {
	
	private int mpId;
	private String mProductName;
	private MyProductInventery mInv;
	public int getMpId() {
		return mpId;
	}
	public void setMpId(int mpId) {
		this.mpId = mpId;
	}
	public String getmProductName() {
		return mProductName;
	}
	public void setmProductName(String mProductName) {
		this.mProductName = mProductName;
	}
	public MyProductInventery getmInv() {
		return mInv;
	}
	public void setmInv(MyProductInventery mInv) {
		this.mInv = mInv;
	}
	
	public void showDetails() {
		System.out.println("product id= "+mpId);
		System.out.println("product Name= "+ mProductName);
		System.out.println("product inventry is = "+ mInv);
	}
	
}
