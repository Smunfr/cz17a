package data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity(name="Answer")
@XmlRootElement
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Question question;
	
	private String content;
	private boolean type;
	/**
	 * Default Constructor
	 */
	public Answer() {}
	/**
	 * Copy Constructor
	 * @param a an Answer Object
	 */
	public Answer(Answer a) {
		this.ID = a.getID();
		this.content = a.getContent();
		this.type = a.getType();
		this.question = new Question(a.getQuestion());
	}
	/**
	 * Standard Constructor
	 * @param content answer as String
	 * @param type boolean determining if the answer ist right or wrong
	 */
	public Answer(String content, boolean type) {
		this.content = content;
		this.type = type;
	}

	@XmlElement
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@XmlElement
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@XmlElement
	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	
	@XmlTransient
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
