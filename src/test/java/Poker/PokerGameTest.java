package Poker;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.pokerHands.PokerGame;
import com.capgemini.pokerHands.PokerGame.RESULT;

public class PokerGameTest {


	@Test
	public void player2ShouldWin() {
		PokerGame game = new PokerGame("8C TS KC 9H 4S 7D 2S 5D 3S AC");
		Assert.assertEquals(RESULT.PLAYER2, game.getWinner());
	}
	@Test
	public void player1ShouldWin() {
		PokerGame game = new PokerGame("8C 8S KC 9H 4S 7D 2S 5D 3S AC");
		Assert.assertEquals(RESULT.PLAYER1, game.getWinner());
	}
	@Test
	public void shouldBeATie() {
		PokerGame game = new PokerGame("8C 8S KC 9H 4S 8D 8H KD 9S 4C");
		Assert.assertEquals(RESULT.TIE, game.getWinner());
	}

}
