package open.vision.app.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import open.vision.app.domain.Answer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("questions")
//	@JsonIgnore
	private List<Answer> answers;
		
	public Question() {
//		super();
//		this.id = null;
//		this.title = null;
//		this.answer = null;
	}

	public Question(String title) {
		super();
		this.title = title;
		// this.answer = answer;
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
	
	public void setTitle(String title) {
		this.title = title;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", answers=" + answers + "]";
	}

}
