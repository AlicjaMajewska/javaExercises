package javaExercises;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.capgemini.fibonacci.Fibonacci;

public class FibonacciTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shouldRetun1for1() throws IOException {
		long fib = Fibonacci.fib(1);
		Assert.assertEquals(1, fib);
	} 
	@Test
	public void shouldRetun1for2() throws IOException {
		long fib = Fibonacci.fib(2);
		Assert.assertEquals(1, fib);
	} 
	@Test
	public void shouldRetun2for3() throws IOException {
		long fib = Fibonacci.fib(3);
		Assert.assertEquals(2, fib);
	} 
	@Test
	public void shouldRetun1597for17() throws IOException {
		long fib = Fibonacci.fib(17);
		Assert.assertEquals(1597, fib);
	} 
	@Test
	public void shouldRetun4181for19() throws IOException {
		long fib = Fibonacci.fib(19);
		Assert.assertEquals(4181, fib);
	} 
	
	@Test
	public void shouldThrowforZero() throws IOException {
		thrown.expect(IOException.class);
		Fibonacci.fib(0);
	}
	@Test
	public void shouldThrowforNegative() throws IOException {
		thrown.expect(IOException.class);
		Fibonacci.fib(-1);
	}
	@Test
	public void shouldThrowCorrectMessage() throws IOException {
		thrown.expectMessage("Uncorrect argument - it must be a positive number");
		Fibonacci.fib(-1);
	}
	
}