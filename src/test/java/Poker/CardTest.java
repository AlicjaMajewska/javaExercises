package Poker;

import org.junit.Assert;

import org.junit.Test;

import com.capgemini.pokerHands.Card;

public class CardTest {
	Card card = new Card("5H");
	@Test
	public void cardsShouldBeEquaö () {
		Card card2 = new Card("5H");
		Assert.assertTrue(card.equals(card2));
	}
	
	@Test
	public void cardShouldBeGreaterThanCard2 () {
		Card card2 = new Card("4S");
		Assert.assertTrue(1 == card.compareTo(card2) );
	}
	@Test
	public void cardsShouldBeEven() {
		Card card2 = new Card("5S");
		Assert.assertTrue(0 == card.compareTo(card2) );
	}
	@Test
	public void shouldBeExuealsFor8C_8C() {
		Card card2 = new Card("8C");
		Card card3 = new Card("8C");
		Assert.assertEquals(card2, card3 );
	}
	@Test
	public void cardShouldBeSmallerThanCatd2() {
		Card card2 = new Card("7S");
		Assert.assertTrue(-1 == card.compareTo(card2) );
	}

}
