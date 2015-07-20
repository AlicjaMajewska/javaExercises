package com.capgemini.pokerHands;

public class FrequencyOfCard implements Comparable<FrequencyOfCard> {
	private Card card;
	private Integer frequency;

	public FrequencyOfCard(Card card, Integer freuency) {
		this.card = card;
		this.frequency = freuency;
	}

	@Override
	public int compareTo(FrequencyOfCard freq2) {
		return this.frequency.equals(freq2.frequency) ? this.card
				.compareTo(freq2.card) : this.frequency
				.compareTo(freq2.frequency);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result
				+ ((frequency == null) ? 0 : frequency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequencyOfCard other = (FrequencyOfCard) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FrequencyOfCard [card=" + card + ", frequency=" + frequency
				+ "]";
	}

	public Card getCard() {
		return card;
	}

	public Integer getFrequency() {
		return frequency;
	}

}
