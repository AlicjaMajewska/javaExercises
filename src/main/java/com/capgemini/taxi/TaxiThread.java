package com.capgemini.taxi;

import java.util.Random;

public class TaxiThread extends Thread implements Comparable<TaxiThread> {
	private static final int CITY_RADIUS = 10000; // m
	private static final int SLEEP_TIME_TAXI = 5000; // ms
	private static final int CLOSE_TO_CLIENT = 1000;
	Random rand = new Random();
	private int x = rand.nextInt(CITY_RADIUS);
	private int y = rand.nextInt(CITY_RADIUS);
	private boolean goUp = rand.nextBoolean();
	private boolean goLeft = rand.nextBoolean();
	private long taxiId = currentThread().getId();

	public void run() {
		while (!isInterrupted()) {
			if (goUp && x < CITY_RADIUS) {
				x += 50;
			}
			if (!goUp &&  x > - CITY_RADIUS) {
				x -= 50;
			}
			goUp = rand.nextBoolean();
			if (goLeft && y < CITY_RADIUS) {
				y += 50;
			}
			if (!goLeft && y > - CITY_RADIUS) {
				y -= 50;
			}
			goUp = rand.nextBoolean();

			//System.out.println("Hello from a thread!");

			try {
				Thread.sleep(SLEEP_TIME_TAXI);

			} catch (InterruptedException e) {
				return;
			}
		}

	}

	public int countDistance() {
		return (int) Math.sqrt(x * x + y * y );
	}
	public boolean isClose()
	{
		return countDistance() < CLOSE_TO_CLIENT;
	}
	public void changeCoordinate(int userX, int userY){
		x -= userX;
		y -= userY;
	}

	public long getTaxiId(){
		return taxiId;
	}
	
	

	public int compareTo(TaxiThread taxiThread) {
		if (this.countDistance() > taxiThread.countDistance()){
			return 1;
		}
		if (this.countDistance() < taxiThread.countDistance()){
		return -1;
		}
		return 0;
	}

}
