package oto.mto.assig;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int publicationId;
	
	
	private String publicationName;
	
	@OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
	private Book book;
	
	
	public int getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}
	public String getPublicationName() {
		return publicationName;
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
