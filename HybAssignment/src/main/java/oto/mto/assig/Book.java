package oto.mto.assig;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String bookName;
	private int PageNo;
	
	@ManyToOne(targetEntity = Publication.class,cascade =CascadeType.ALL )
	private Publication bookPubl;
	
	
	public Publication getBookPubl() {
		return bookPubl;
	}
	
	public void setBookPubl(Publication bookPubl) {
		this.bookPubl = bookPubl;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPageNo() {
		return PageNo;
	}
	public void setPageNo(int pageNo) {
		PageNo = pageNo;
	}
	
}
