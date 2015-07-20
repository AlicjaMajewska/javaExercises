package com.capgemini.fibonacci;

import java.io.IOException;
import java.util.Scanner;


public class StartFibonacci {

   /* This is my first java program.  
    * This will print 'Hello World' as the output
    */

    private static Scanner in;

	public static void main(String []args) {
       System.out.println("Hello World"); // prints Hello World
       System.out.println("Program calculates value of the chosen number of Fibonacci chain.");
       System.out.println("Add the number if of Fibonacci chain:");
       in = new Scanner(System.in);
       int arg = in.nextInt();
       try{
       System.out.println("The value is " + Fibonacci.fib(arg));
       }
       catch(IOException except) {
    	   System.out.println(except);
       }
       
       
       
    }
} 