package com.capgemini.pokerHands;


public enum COLOR {
	C("C"), D("D"), H("H"), S("S");
	private final String color;

	COLOR(String col) {
		this.color = col;
	}

	public String GetColor() {
		return color;
	}

	public static COLOR getColor(String stringColor) {
		for (COLOR enumColor : COLOR.values()) {
			if (enumColor.color.equals(stringColor)) {
				return enumColor;
			}
		}
		return null;
	}
}
