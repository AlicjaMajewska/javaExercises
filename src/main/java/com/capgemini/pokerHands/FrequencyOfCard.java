package com.capgemini.pokerHands;

public class FrequencyOfCard implements Comparable<FrequencyOfCard> {
	private VALUE cardValue;
	private Integer frequency;

	public FrequencyOfCard(VALUE cardValue, Integer freuency) {
		this.cardValue = cardValue;
		this.frequency = freuency;
	}

	@Override
	public int compareTo(FrequencyOfCard freq2) {
		return this.frequency.equals(freq2.frequency) ? 
				(new Integer(this.cardValue.ordinal())).compareTo(new Integer(freq2.cardValue.ordinal()))
				: this.frequency.compareTo(freq2.frequency);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardValue == null) ? 0 : cardValue.hashCode());
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
		if (cardValue == null) {
			if (other.cardValue != null)
				return false;
		} else if (!cardValue.equals(other.cardValue))
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
		return "FrequencyOfCard [card=" + cardValue + ", frequency=" + frequency
				+ "]";
	}

	public VALUE getCardValue() {
		return cardValue;
	}

	public Integer getFrequency() {
		return frequency;
	}

}
