package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
	private List<Card> sortedHand = new ArrayList<Card>();
	private List<FrequencyOfCard> frequencyOfCards = new ArrayList<FrequencyOfCard>();
	private RANKS rank;

	public Player(String hand) {
		String[] cards = hand.split(" ");
		for (String string : cards) {
			sortedHand.add(new Card(string));
		}
		Collections.sort(sortedHand);
		fillListFrequencyOfCards();
		Collections.sort(frequencyOfCards);
		Collections.reverse(frequencyOfCards);
		deduceRank();
	}

	private void deduceRank() {
		switch (frequencyOfCards.get(0).getFrequency()) {
		case 4:
			rank = RANKS.FOUR_OF_A_KIND;
			break;
		case 3:
			rank = RANKS.THREE_OF_A_KIND;
			if (frequencyOfCards.get(1).getFrequency() == 2) {
				rank = RANKS.FULL_HOUSE;
			}
			break;
		case 2: 
			rank = RANKS.ONE_PAIR;
			if(frequencyOfCards.get(1).getFrequency() == 2){
				rank = RANKS.TWO_PAIRS;
			}
			break;
		case 1:
			if(isStraight() && isFlush()){
				if(frequencyOfCards.get(0).getCardValue().equals(VALUE.A)){
					rank = RANKS.ROYAL_FLUSH;
					break;
				}
				rank = RANKS.STRAIGHT_FLUSH;
				break;
			}
			if(isStraight()){
				rank = RANKS.STRAIGHT;
				break;
			}
			if(isFlush()){
				rank = RANKS.FLUSH;
				break;
			}
			rank = RANKS.HIGH_CARD;
			break;
		}
	}

	private boolean isStraight() {
		return frequencyOfCards.size() == 5
				&& sortedHand.get(sortedHand.size() - 1).getDifference(
						sortedHand.get(0)) == 4;
	}

	private boolean isFlush() {
		Card previousCard = sortedHand.get(0);
		for (Card card : sortedHand) {
			if (!previousCard.theSameColor(card)) {
				return false;
			}
		}
		return true;
	}

	private void fillListFrequencyOfCards() {
		HashMap<VALUE, Integer> cardFrequencyMap = new HashMap<VALUE,Integer>();
		for (Card card : sortedHand) {
			if(!cardFrequencyMap.containsKey(card.getValue())){
				cardFrequencyMap.put(card.getValue(), new Integer(0));
			}
			cardFrequencyMap.put(card.getValue(), cardFrequencyMap.remove(card.getValue()) + 1 );
		}
		for(Map.Entry<VALUE, Integer> entry : cardFrequencyMap.entrySet()){
			frequencyOfCards.add(new FrequencyOfCard(entry.getKey(), entry.getValue()));
		}

		
	}

	public RANKS getRank() {
		return rank;
	}

	public int compareTo(Player player2) {
		
		if(this.rank != player2.rank){
			return this.rank.ordinal() > player2.rank.ordinal() ? 1 : -1;
		}
		for (int i = 0; i < frequencyOfCards.size(); ++i)
			if(0 != frequencyOfCards.get(i).compareTo(player2.frequencyOfCards.get(i))){
				return frequencyOfCards.get(i).compareTo(player2.frequencyOfCards.get(i));
		}
		return 0;
	}

}
