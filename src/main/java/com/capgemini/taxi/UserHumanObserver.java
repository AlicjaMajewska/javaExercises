package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.List;

public class UserHumanObserver {
	private int x;
	private int y;
	List<TaxiThread> closeTaxiList = new ArrayList<TaxiThread>();
	public UserHumanObserver(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public List<TaxiThread> getCloseTaxiList(){
		return closeTaxiList;
	}
		
	public void updateCloseTaxiList(List<TaxiThread> closeTaxiList){
		this.closeTaxiList = closeTaxiList;
	}

	public void getTaxi(TaxiList taxiList, TaxiList copyTaxiList) {
		if(!closeTaxiList.isEmpty()){
		TaxiThread chosenTaxi = closeTaxiList.get(0);
		taxiList.getTaxi(chosenTaxi.getId());
		copyTaxiList.getTaxi(chosenTaxi.getId());
		System.out.println("Wybrano taksowke oddalona o " + chosenTaxi.countDistance());
		chosenTaxi.interrupt();
		}
		
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	

}
