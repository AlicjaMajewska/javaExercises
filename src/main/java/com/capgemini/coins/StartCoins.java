package com.capgemini.coins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartCoins {

	public static void main(String []args) {
	List<Integer> myCoins = new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,0));
	System.out.println("Obliczenie zadania coins ");
	System.out.println("wynik obliczen: " + Coins.solution(myCoins) );
	
	}
}
	