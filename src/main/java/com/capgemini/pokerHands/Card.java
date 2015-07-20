package com.capgemini.pokerHands;




public class Card implements Comparable<Card> {	
	VALUE value;
	COLOR color;
	
	public Card(String name){
		value = VALUE.getValue(name.substring(0, 1));
		color = COLOR.getColor(name.substring(1, 2));
	}
	public int getDifference(Card card2){
		return Math.abs(this.value.ordinal() - card2.value.ordinal());
	}
	public boolean theSameColor(Card card2){
		return this.color == card2.color;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", color=" + color + "]";
	}
	
	public int compareTo(Card card2)
	{
		
		if (value.ordinal() < card2.value.ordinal())
		{
			return -1;
		}
		if (value.ordinal() > card2.value.ordinal())
		{
			return 1;
		}
			return 0;               
	}
	
	

}
