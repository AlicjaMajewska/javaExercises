package com.capgemini.pokerHands;

public enum VALUE {
	_2("2"), _3("3"), _4("4"), _5("5"), _6("6"), _7("7"), _8("8"), _9("9"),
		_10("T"), J("J"), Q("Q"), K("K"), A("A");
	private String value;

	VALUE(String val) {
		value = val;
	}

	public static VALUE getValue(String sign) {
		for (VALUE enumValue : VALUE.values()) {
			if (enumValue.value.equals(sign)) {
				return enumValue;
			}
		}
		return null;
	}
}
