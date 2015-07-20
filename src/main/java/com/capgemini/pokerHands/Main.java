package com.capgemini.pokerHands;

import java.io.*;
import java.util.Scanner;

import com.capgemini.pokerHands.PokerGame.RESULT;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(
					"src/main/java/com/Capgemini/pokerHands/poker.txt")));
			int player1Winns = 0;
			while (scanner.hasNext()) {
				PokerGame pokerGame = new PokerGame(scanner.nextLine());
				if (pokerGame.getWinner() == RESULT.PLAYER1){
					++player1Winns;
				}
			}
			System.out.println("Gracz pierwszy wygral " + player1Winns + " razy.");
		} catch (FileNotFoundException e) {
			System.err
					.println("Bledna nazwa pliku odczytu, nie mozna kontynuowac programu. ");
			System.exit(1);
		} finally {
			if (scanner != null) {
				scanner.close();
			}

		}
	}

}
