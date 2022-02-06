package manytomany;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="testmcq")
public class Multiquestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	private String questionName;
	
	@ManyToMany(targetEntity = MultiAnswer.class,cascade = CascadeType.ALL)
	@JoinTable(name="testmcq_join",
    joinColumns = {@JoinColumn(name="mcqqid")},
    inverseJoinColumns= {@JoinColumn(name="mcqansid")})
	private List<MultiAnswer> answers;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public List<MultiAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<MultiAnswer> answers) {
		this.answers = answers;
	}
}
