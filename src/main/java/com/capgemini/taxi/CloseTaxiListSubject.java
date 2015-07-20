package com.capgemini.taxi;

import java.util.List;

// 
public class CloseTaxiListSubject {

	UserHumanObserver userHuman;
	TaxiList taxiListCopy;

	public CloseTaxiListSubject(TaxiList taxiListCopy) {
		this.taxiListCopy = taxiListCopy;
	}

	public void addUserHuman(UserHumanObserver userHuman) {
		this.userHuman = userHuman;
		List<TaxiThread> closeTaxiList = taxiListCopy.makeListOfCloseTaxies();
		userHuman.updateCloseTaxiList(closeTaxiList);
	}
	public void printCloseTaxiList(List<TaxiThread> closeTaxiList){
		for (TaxiThread taxiThread : closeTaxiList) {
			System.out.print(taxiThread.countDistance() + " | ");
		}
		System.out.println("");
	}

	
	public void removeUserHuman() { // should be done better
		userHuman = null;
	}

	public void notifyObserver() {

		if (userHuman != null) {
			List<TaxiThread> closeTaxiList = taxiListCopy
					.makeListOfCloseTaxies();
			boolean equals = true;
			if (closeTaxiList.size() == userHuman.getCloseTaxiList().size()) {
				equals = false;
			}
			for (int i = 0; i < closeTaxiList.size() && equals; ++i) {
				if (closeTaxiList.get(i).getId() != userHuman
						.getCloseTaxiList().get(i).getId()) {
					equals = false;
				}
			}
			if (!equals) {
				userHuman.updateCloseTaxiList(closeTaxiList);
			}
			printCloseTaxiList(closeTaxiList);

		}
	}
}
