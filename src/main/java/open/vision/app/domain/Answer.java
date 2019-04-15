package open.vision.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerid;
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Question question;

	public Answer() {}

	public Answer(String value, Question question) {
		super();
		this.value = value;
		this.question = question;
	}
	
	public Long getAnswerid() {
		return answerid;
	}

	public void setAnswerid(Long answerid) {
		this.answerid = answerid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Question getQuestions() {
		return question;
	}

	public void setQuestions(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [answerid=" + answerid + ", value=" + value + ", question=" + question + "]";
	}

}
