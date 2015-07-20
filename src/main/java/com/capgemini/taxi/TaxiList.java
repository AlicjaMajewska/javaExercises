package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TaxiList {
	private static final int MAX_TAXIES_IN_CITY = 20000;
	private static final int MAX_FREE_TAXIES_NUMBER = 20;
	List<TaxiThread> taxiList; 
	
	public TaxiList() {
		taxiList = new ArrayList<TaxiThread>();
		for (int i = 0; i < MAX_TAXIES_IN_CITY; ++i) {
			taxiList.add(new TaxiThread());
			taxiList.get(i).start();
		}
	}
	public TaxiList(TaxiList oldTaxiList){
		taxiList = new ArrayList<TaxiThread>(oldTaxiList.taxiList);
	}
	
	public void translateToUser(int userX, int userY){
		for (TaxiThread taxiThread : taxiList) {
			taxiThread.changeCoordinate(userX, userY);
			
		}
	}
	
	public int size(){
		if(taxiList == null){
			return 0;
		}
		return taxiList.size();
	}
	
	public void getTaxi(long taxiId){
		for (Iterator<TaxiThread> iterator = taxiList.iterator(); iterator.hasNext();) {
			TaxiThread taxi = iterator.next();
			if(taxi.getId() == taxiId){
				iterator.remove();				
			}
		}
	}
	
	public void endTaxiList(){
		for (TaxiThread taxiThread : taxiList) {
			taxiThread.interrupt();
			try {
				taxiThread.join(5000);
			} catch (InterruptedException e) {
				// wath to do to?
				
			}
		}
	}

	public synchronized void sortTaxiList() {
		Collections.sort(taxiList);
	}

	public synchronized List<TaxiThread> makeListOfCloseTaxies() {
		List<TaxiThread> closeTaxiList = new ArrayList<TaxiThread>();
		sortTaxiList();
		for (int i = 0; i < MAX_FREE_TAXIES_NUMBER && !taxiList.isEmpty(); ++i) {
			TaxiThread taxi = taxiList.get(i);
			if (!taxi.isClose()) {
				break;
			}
			closeTaxiList.add(taxi);
		}
		return closeTaxiList;
	}

	public synchronized void addTaxi(TaxiThread taxi) {
		taxiList.add(taxi);
	}

	public synchronized TaxiThread getTaxi() {
		TaxiThread taxi = new TaxiThread();
		if (!taxiList.isEmpty()) {
			taxi = taxiList.remove(0);
		}
		return taxi;
	}

	

}
