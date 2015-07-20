package javaExercises;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.placeToSplit.PlaceToSplit;

public class PlaceToSplitTest {

	@Test
	public void shouldSplitFor10_5_10_2_3() {
		int [] tab1 = new int[]{10,5,10,2,3};
		Assert.assertTrue(PlaceToSplit.canBalance(tab1));
	}
	@Test
	public void shouldNotSplitFor10_5_10_2_1() {
		int [] tab1 = new int[]{10,5,10,2,1};
		Assert.assertFalse(PlaceToSplit.canBalance(tab1));
	}
	@Test
	public void shouldNotSplitForEmpty(){
		int [] tab1 = new int[]{};
		Assert.assertFalse(PlaceToSplit.canBalance(tab1));
	}
	@Test
	public void shouldNotSplitForOneElement(){
		int [] tab1 = new int[]{2};
		Assert.assertFalse(PlaceToSplit.canBalance(tab1));
	}

	@Test
	public void shouldSplitFor1_1_1_2_1(){
		int [] tab1 = new int[]{1, 1, 1, 2, 1};
		Assert.assertTrue(PlaceToSplit.canBalance(tab1));
	}
	@Test
	public void shouldSplitFor10_10(){
		int [] tab1 = new int[]{10, 10};
		Assert.assertTrue(PlaceToSplit.canBalance(tab1));
	}
	@Test
	public void shouldNotSplitFor2_1_1_2_1(){
		int [] tab1 = new int[]{2, 1, 1, 2, 1};
		Assert.assertFalse(PlaceToSplit.canBalance(tab1));
	}

}
