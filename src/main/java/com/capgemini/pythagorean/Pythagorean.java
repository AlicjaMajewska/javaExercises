package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52. There exists
 * exactly one Pythagorean triplet for which a + b + c = 1000. Find the product
 * abc.
 */

public class Pythagorean {
	private final int SUM = 1000;
	private int[] numbers = new int [3];
	
	public  int[] getNumbers() 
	{
		return numbers;
	}
	public void printNumbers()
	{
		for (int i : numbers)
		{
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	public int calculate(){
		
		for(int a = 1; a < SUM/3; ++a )
		{
			for (int b = 2; b < SUM * 2 / 3; ++b)
			{
				if ((a * a + b * b) == (SUM - a - b) * (SUM - a - b))
					{
						numbers[0] = a;
						numbers[1] = b;
						numbers[2] = SUM - a - b;
						return a*b*(SUM-a-b);
					}
			}
		}
		return 0;
		
	}
}
