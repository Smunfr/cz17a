package cz17a.gamification.gameserver;

import java.util.ArrayList;

public class Game {
	private Round round;
	
	public Game(Quiz quiz, ArrayList<Player> players) {
		quiz = new Quiz();
		for(Player player: players) {
			player = new Player();
		}
	}
	/**
	 * Initiate a new Game
	 */
	public void start() {
		
	}
	/**
	 * saves the current Game to DB, to be called after the Game has finished
	 */
	public void saveRound() {
		
	}

}
