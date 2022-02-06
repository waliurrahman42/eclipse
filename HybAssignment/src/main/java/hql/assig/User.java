package hql.assig;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User1")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String username;
	private int  movieid;
	private Double rating;

	private LocalDate date ;
	
	@Column(name="time")
	private int time;
	
	//private LocalTime currentTime;
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int sec) {
		this.time = sec;
	}
	
//	public LocalTime getCurrentTime() {
//		return currentTime;
//	}
//	public void setCurrentTime(LocalTime currentTime) {
//		this.currentTime = currentTime;
//	}


}
