package data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Played_Question")
public class PlayedQuestion implements Serializable {
	@Id
	@ManyToOne
	private Question question;
	@Id
	@ManyToOne
	private Round round;
	@Id
	@ManyToOne
	private Player player;
	@Column(name = "is_jackpot")
	private boolean isJackpot;
	@Column(name = "is_correct")
	private boolean isCorrect;
	@Column(name = "speed_in_seconds")
	private double speedInSeconds;
	private int score;
	
	public PlayedQuestion() {}
	
	public PlayedQuestion(Question question, Round round, Player player) {
		this.question = question;
		this.round = round;
		this.player = player;
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Round getRound() {
		return round;
	}
	public void setRound(Round round) {
		this.round = round;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public boolean isIsJackpot() {
		return isJackpot;
	}
	public void setIsJackpot(boolean isJackpot) {
		this.isJackpot = isJackpot;
	}
	public boolean isIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getSpeedInSeconds() {
		return speedInSeconds;
	}
	public void setSpeedInSeconds(double speedInSeconds) {
		this.speedInSeconds = speedInSeconds;
	}
	
	

}
