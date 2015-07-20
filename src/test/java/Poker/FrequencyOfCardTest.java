package Poker;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.pokerHands.Card;
import com.capgemini.pokerHands.FrequencyOfCard;

public class FrequencyOfCardTest {
	FrequencyOfCard freq3Ace = new FrequencyOfCard(new Card("AC"), 3);
	FrequencyOfCard freq2Ace= new FrequencyOfCard(new Card("AD"), 2);
	FrequencyOfCard freq3King= new FrequencyOfCard(new Card("KD"), 3);
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldSetObjectCorrectly() {
		Assert.assertTrue(3 == freq3Ace.getFrequency());
	}
	@Test
	public void freq3AceShouldBeGreaterThanfreq2Ace() {
		Assert.assertTrue(1 == freq3Ace.compareTo(freq2Ace));
	}
	@Test
	public void freq3AceShouldBeGreaterThanfreq3King() {
		Assert.assertTrue(1 == freq3Ace.compareTo(freq3King));
	}
	@Test
	public void freq3KingShouldBeGreaterThanfreq2Ace() {
		Assert.assertTrue(1 == freq3King.compareTo(freq2Ace));
	}

}
