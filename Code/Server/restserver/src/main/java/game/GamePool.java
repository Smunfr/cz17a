package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import data.model.Player;
import data.model.Quiz;

public class GamePool {
	public static Map<Integer, Game> games = new HashMap<Integer, Game>();
	
	/**
	 * adds a game to the list of active games, starts it
	 * current max: 1000 games
	 * @param quiz
	 * @param players
	 * @param sockets
	 */
	public static void startGame(Quiz quiz, List<Player> players) {
		int id;
		for(id = 0; id <= 1000; id++) {
			if(games.containsKey(id) == false) {
				Game game = new Game(id, quiz, players);
				games.put(id, game);
				break;
			}
		}
		games.get(id).start();
	}
	
	/**
	 * removes game from list of active games after it has finished
	 * @param id
	 */
	public static void removeGame(int id) {
		if(games.containsKey(id)) {
			games.remove(id);
		}
	}
}
