package com.capgemini.taxi;

public class StartTaxi {
	public static void main(String args[]) throws InterruptedException {

		UserHumanObserver human = new UserHumanObserver(10, 15);
		
		Serwer serwer = new Serwer();
		serwer.serviceUser(human);
		
		Thread.sleep(5000);
		serwer.endServer();
	System.out.println("Koniec");
		
	}
}
