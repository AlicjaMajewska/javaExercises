package Poker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.pokerHands.Player;
import com.capgemini.pokerHands.RANKS;

public class PokerDeduceRankAndCompareTest {
	
	@Test
	public void shouldDeduceFourOfAKind() {
		Player player = new Player("AC AS AD AH 2C");
		Assert.assertEquals(RANKS.FOUR_OF_A_KIND, player.getRank());
	}
	@Test
	public void shouldDeduceFullHause() {
		Player player = new Player("AC AS AD 2H 2C");
		Assert.assertEquals(RANKS.FULL_HOUSE, player.getRank());
	}
	@Test
	public void shouldDeduceThreeOfAKind() {
		Player player = new Player("AC AS AD 2H 8C");
		Assert.assertEquals(RANKS.THREE_OF_A_KIND, player.getRank());
	}
	@Test
	public void shouldDeduceTwoPairs() {
		Player player = new Player("AC 2S AD 2H 8C");
 		Assert.assertEquals(RANKS.TWO_PAIRS, player.getRank());
	}
	@Test
	public void shouldDeduceRoyalFlush() {
		Player player = new Player("TC QC JC AC KC");
		Assert.assertEquals(RANKS.ROYAL_FLASH, player.getRank());
	}
	@Test
	public void shouldDeduceStraightFlush() {
		Player player = new Player("7S 9S 8S TS JS");
		Assert.assertEquals(RANKS.STRAIGHT_FLUSH, player.getRank());
	}
	@Test
	public void shouldDeduceStraight() {
		Player player = new Player("2S 3S 5D 6H 4S");
		Assert.assertEquals(RANKS.STRAIGHT, player.getRank());
	}
	@Test
	public void shouldDeduceFlush() {
		Player player = new Player("2S 3S 9S 6S TS");
		Assert.assertEquals(RANKS.FLUSH, player.getRank());
	}
	@Test
	public void shouldDeduceHighCard() {
		Player player = new Player("2S 3D 5S QS 4S");
		Assert.assertEquals(RANKS.HIGH_CARD, player.getRank());
	}
	@Test
	public void shouldDeduceHighCardASHigherThanQC() {
		Player player1 = new Player("AS 3D 5S 7D JS");
		Player player2 = new Player("QC 8H 5S 7D 2S");
		Assert.assertTrue(1 == player1.compareTo(player2));
	}
	@Test
	public void shouldDeduceHighCardSevenSmallerThanQC() {
		Player player1 = new Player("2S 3D 5S 7D 6S");
		Player player2 = new Player("QC 8H 5S 7D 2S");
		Assert.assertFalse(1 == player1.compareTo(player2));
	}
	@Test
	public void shouldDeduceRoyalFlushHigherThanFourOfAKind() {
		Player player1 = new Player("AS KS QS TS JS");
		Player player2 = new Player("QC QH QS QD 2S");
		Assert.assertTrue(1 == player1.compareTo(player2));
	}
	@Test
	public void shouldDeduceTwoPairsAndKingHigherThanTwoPairsAndTen() {
		Player player1 = new Player("AS AC QS KS QH");
		Player player2 = new Player("AD AH QD TS QC");
		Assert.assertTrue(1 == player1.compareTo(player2));
	}
	

}
