package com.capgemini.placeToSplit;

public class StartPlaceToSplit {

	  public static void main(String []args) {
		  int [] tab = new int[]{10,5,10,2,3};
	       // tu dopracowac albo wcztywanie tablicy z plikow albo z konsoli
	       
	       if (PlaceToSplit.canBalance(tab))
	       {
	    	   System.out.println("Gut!");
	       }
	       else 
	       {
	    	   System.out.println("Nicht gut!");
	       }
	    }
	} 