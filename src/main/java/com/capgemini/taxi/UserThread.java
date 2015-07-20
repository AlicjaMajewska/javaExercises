package com.capgemini.taxi;

import java.util.Random;

public class UserThread extends Thread {
	private static final int SLEEP_TIME_USER = 500; // ms
	Random rand = new Random();
	boolean ad_or_remove = true;
	TaxiList taxiList;

	public UserThread(TaxiList taxiList) {
		this.taxiList = taxiList;
	}

	public void addTaxi() {
		TaxiThread taxi = new TaxiThread();
		taxi.start();
		taxiList.addTaxi(taxi);
	}

	public void getTaxi() {
		TaxiThread taxi = taxiList.getTaxi();
		if (taxi != null) {

			taxi.interrupt();
		}
	}

	public void run() {

		while (!isInterrupted()) {
			ad_or_remove = rand.nextBoolean();
			if (ad_or_remove) {
				addTaxi();
			} else {
				getTaxi();
			}

			try {
				Thread.sleep(SLEEP_TIME_USER);

			} catch (InterruptedException e) {
				return;
			}
		}
	}

}