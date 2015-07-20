package Poker;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.pokerHands.Card;
import com.capgemini.pokerHands.FrequencyOfCard;
import com.capgemini.pokerHands.Player;
import com.capgemini.pokerHands.VALUE;

public class PlayerPokerTest {
	Player player1 = new Player("8C TS KC 9H 4S");
	Player player2 = new Player("AH AS KC KS KD");
	Player player3 = new Player("8C 8S 6C AS 6D");
	Player player4 = new Player("QH AS QC KS KD");

	@Test
	public void shouldCreateSortedListOfCardsPlayer1() {
		List<Card> cardList = new ArrayList<Card>(
				Arrays.asList(new Card("4S"), new Card("8C"), new Card("9H"),
						new Card("TS"), new Card("KC")));
		// Assert.assertArrayEquals(cardList, player1.getArrayCard());
		try {
			Field field;
			field = Player.class.getDeclaredField("sortedHand");
			field.setAccessible(true);
			List<Card> cardListPlayer1 = (List<Card>) field
					.get(player1);
			for (int i = 0; i < cardListPlayer1.size(); ++i) {
				Assert.assertEquals(cardListPlayer1.get(i), cardList.get(i));
			}

		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void shouldCreateSortedListOfCardsPlayer3() {
		List<Card> cardList = new ArrayList<Card>(
				Arrays.asList(new Card("6C"), new Card("6D"), new Card("8C"),
						new Card("8S"), new Card("AS")));
		// Assert.assertArrayEquals(cardList, player1.getArrayCard());
		try {
			Field field;
			field = Player.class.getDeclaredField("sortedHand");
			field.setAccessible(true);
			List<Card> cardListPlayer3 = (List<Card>) field
					.get(player3);
			for (int i = 0; i < cardListPlayer3.size(); ++i) {
				Assert.assertEquals(cardListPlayer3.get(i), cardList.get(i));
			}
			
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void shouldCreateSortedListOfFrequencyOfCardsPlayer1PrivateAccessor() {
		List<FrequencyOfCard> freqCardList = new ArrayList<FrequencyOfCard>(
				Arrays.asList(new FrequencyOfCard(VALUE.K,	new Integer(1)),
						new FrequencyOfCard(VALUE._10, new Integer(1)), 
						new FrequencyOfCard(VALUE._9, new Integer(1)),
						new FrequencyOfCard(VALUE._8 ,new Integer(1)),
						new FrequencyOfCard(VALUE._4,new Integer(1))));

		try {
			Field field;
			field = Player.class.getDeclaredField("frequencyOfCards");
			field.setAccessible(true);
			List<FrequencyOfCard> freqListPlayer1 = (List<FrequencyOfCard>) field
					.get(player1);
			for (int i = 0; i < freqListPlayer1.size(); ++i) {
				Assert.assertEquals(freqListPlayer1.get(i), freqCardList.get(i));
			}

		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void shouldCreateSortedListOfFrequencyOfCardsPlayer2() {
		List<FrequencyOfCard> freqCardList = new ArrayList<FrequencyOfCard>(
				Arrays.asList(new FrequencyOfCard(VALUE.K,	new Integer(3)), 
						new FrequencyOfCard(VALUE.A, new Integer(2))));
		try {
			Field field;
			field = Player.class.getDeclaredField("frequencyOfCards");
			field.setAccessible(true);
			List<FrequencyOfCard> freqListPlayer2 = (List<FrequencyOfCard>) field
					.get(player2);
			for (int i = 0; i < freqListPlayer2.size(); ++i) {
				Assert.assertEquals(freqCardList.get(i), freqListPlayer2.get(i));
			}
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void shouldCreateSortedListOfFrequencyOfCardsPlayer3() {
		List<FrequencyOfCard> freqCardList = new ArrayList<FrequencyOfCard>(
				Arrays.asList(new FrequencyOfCard(VALUE._8,	new Integer(2)), 
						new FrequencyOfCard(VALUE._6, new Integer(2)), 
						new FrequencyOfCard(VALUE.A, new Integer(1))));
		try {
			Field field;
			field = Player.class.getDeclaredField("frequencyOfCards");
			field.setAccessible(true);
			List<FrequencyOfCard> freqListPlayer3 = (List<FrequencyOfCard>) field
					.get(player3);
			for (int i = 0; i < freqListPlayer3.size(); ++i) {
				Assert.assertEquals(freqCardList.get(i), freqListPlayer3.get(i));
			}
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void shouldCreateSortedListOfFrequencyOfCardsPlayer4() {
		List<FrequencyOfCard> freqCardList = new ArrayList<FrequencyOfCard>(
				Arrays.asList(new FrequencyOfCard(VALUE.K, new Integer(2)),
						new FrequencyOfCard(VALUE.Q, new Integer(2)), 
						new FrequencyOfCard(VALUE.A,new Integer(1))));
		try {
			Field field;
			field = Player.class.getDeclaredField("frequencyOfCards");
			field.setAccessible(true);
			List<FrequencyOfCard> freqListPlayer4 = (List<FrequencyOfCard>) field
					.get(player4);
			for (int i = 0; i < freqListPlayer4.size(); ++i) {
				Assert.assertEquals(freqCardList.get(i), freqListPlayer4.get(i));
			}
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
