package data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Quiz_Participation")
public class Participation implements Serializable {
	@Id
	@ManyToOne
	private Player player;
	@Id
	@ManyToOne
	private Round round;
	private int rank;
	private int score;
	
	public Participation() {}

	public Participation(Player player, Round round) {
		this.player = player;
		this.round = round;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void addPoints(int points) {
		this.score += points;
	}

}