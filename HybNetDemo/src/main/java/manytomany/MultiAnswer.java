package manytomany;

import javax.persistence.*;

@Entity
@Table(name="test_ans")
public class MultiAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int answerId;
	private String ansName;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnsName() {
		return ansName;
	}
	public void setAnsName(String ansName) {
		this.ansName = ansName;
	}

	
}