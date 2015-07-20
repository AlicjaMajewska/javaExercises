package javaExercises;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.pascalrectangle.PascalRectangle;

public class PascalRectangleTest {

	
	@Test
	public void shouldReturn1for0_0() {
		Assert.assertEquals(1, PascalRectangle.pascal(0,0));
	}
	@Test
	public void shouldReturn1for0_1() {
		Assert.assertEquals(1, PascalRectangle.pascal(0,1));
	}
	@Test
	public void shouldReturn1for1_1() {
		Assert.assertEquals(1, PascalRectangle.pascal(1,1));
	}
	@Test
	public void shouldReturn2for2_1() {
		Assert.assertEquals(2, PascalRectangle.pascal(2,1));
	}
	@Test
	public void shouldReturn3for2_3() {
		Assert.assertEquals(3, PascalRectangle.pascal(2,3));
	}
	@Test
	public void shouldReturn6for2_4() {
		Assert.assertEquals(6, PascalRectangle.pascal(2,4));
	}
	@Test
	public void shouldReturn126for4_9() {
		Assert.assertEquals(126, PascalRectangle.pascal(4,9));
	}

}
