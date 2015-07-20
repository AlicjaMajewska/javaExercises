package com.capgemini.taxi;

public class Serwer {
	private TaxiList taxiList;
	UserThread userThread;
	CloseTaxiListSubject closeTaxiListSubject;

	Serwer() {
		taxiList = new TaxiList();
		userThread = new UserThread(taxiList);
		userThread.start();
	}

	public void serviceUser(UserHumanObserver userHuman) {

		taxiList.translateToUser(userHuman.getX(), userHuman.getY());
		CloseTaxiListSubject closeTaxiListSubject = new CloseTaxiListSubject(
				taxiList);
		closeTaxiListSubject.addUserHuman(userHuman);
		closeTaxiListSubject.notifyObserver();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		closeTaxiListSubject.notifyObserver();
		userHuman.getTaxi(taxiList, taxiList);
		closeTaxiListSubject.removeUserHuman();
		taxiList.translateToUser(-userHuman.getX(), -userHuman.getY());
	}

	public void endServer() {

		userThread.interrupt();
		try {
			userThread.join(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		taxiList.endTaxiList();
	}

}
