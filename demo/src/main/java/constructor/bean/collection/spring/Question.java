package constructor.bean.collection.spring;

import java.util.List;

public class Question {
		
	private int qid;
	private	String questionName;
	private	List<String> answers;
	
	public Question() {
		
	}
	
	public Question(int qid, String questionName, List<String> answers) {
		
		this.qid = qid;
		this.questionName = questionName;
		this.answers = answers;
	}
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	public void show () {
		System.out.println("question id is "+qid);
		System.out.println("question id is "+questionName);
		for(String q:answers) {
			System.out.println(q.toString());
		}
	}
}
