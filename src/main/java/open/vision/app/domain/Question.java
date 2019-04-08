package open.vision.app.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import open.vision.app.domain.Answer;
import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private ArrayList<String> answers = new ArrayList<>();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="answerid")
	private Answer answer;
	
	
	
	public Question() {
		super();
		this.id = null;
		this.title = null;
	}
	
	public Question(String title, ArrayList<String> answers) {
		this.title = title;
		this.answers = answers;
	}

	public Question(String title) {
		super();
		this.title = title;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	


	public Answer getAnswer() {
		return answer;
	}


	public void setAnswer(Answer answer) {
		this.answer = answer;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", answers=" + answers + "]";
	}
}
