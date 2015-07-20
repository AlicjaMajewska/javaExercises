package javaExercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.capgemini.coins.Coins;

public class CoinsTest {

	@Test
	public void shouldReturn0forEmpty() {
		List<Integer> list1 = new 
				ArrayList<Integer>();
		
		int solution = Coins.solution(list1);
		Assert.assertEquals(0, solution);
	}
	
	@Test
	public void shouldReturn0for1() {
		List<Integer> list1 = new 
				ArrayList<Integer>(Arrays.asList(1));
		
		int solution = Coins.solution(list1);
		Assert.assertEquals(0, solution);
	}
	
	@Test
	public void shouldReturn4for110100() {
		List<Integer> list1 = new 
				ArrayList<Integer>(Arrays.asList(1,1,0,1,0,0));
		
		int solution = Coins.solution(list1);
		Assert.assertEquals(4, solution);
	}
	@Test
	public void shouldReturn0for11() {
		List<Integer> list1 = new 
				ArrayList<Integer>(Arrays.asList(1,1));
		
		int solution = Coins.solution(list1);
		Assert.assertEquals(0, solution);
	}
	@Test
	public void shouldReturnfor1() {
		List<Integer> list1 = new 
				ArrayList<Integer>(Arrays.asList(0,1));
		
		int solution = Coins.solution(list1);
		Assert.assertEquals(1, solution);
	}
	@Test
	public void shouldReturn2for010() {
		List<Integer> list1 = new 
				ArrayList<Integer>(Arrays.asList(0,1,0));
		
		int solution = Coins.solution(list1);
		Assert.assertEquals(2, solution);
	}

}
