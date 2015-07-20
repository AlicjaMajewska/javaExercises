package javaExercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.pythagorean.Pythagorean;

public class PythagoreanTest {
	Pythagorean pythag;
	
	@Before
	public void before(){
		pythag = new Pythagorean();
		pythag.calculate();
	}
	
	@Test
	public void shouldCount() {
		int [] solution = new int [] {200,375,425};
		Assert.assertArrayEquals(solution,pythag.getNumbers());
	}

}
