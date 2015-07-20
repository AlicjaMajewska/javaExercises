package com.capgemini.pokerHands;

public class PokerGame {
	private Player player1;
	private Player player2;

	public enum RESULT {
		PLAYER1, PLAYER2, TIE
	};

	public PokerGame(String cardsDeal) {
		String[] parts = { cardsDeal.substring(0, cardsDeal.length() / 2),
				cardsDeal.substring(cardsDeal.length() / 2 + 1) };
		player1 = new Player(parts[0]);
		player2 = new Player(parts[1]);
	}

	public RESULT getWinner() {
		switch (player1.compareTo(player2)) {
		case 1:
			return RESULT.PLAYER1;
		case -1:
			return RESULT.PLAYER2;
		default:
			return RESULT.TIE;
		}

	}

}
