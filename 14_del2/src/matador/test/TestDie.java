package matador.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import matador.business_logic.*;

import org.junit.Test;

public class TestDie {
	Die die1;	
	Die die2;

	/**
	 * Tests the normal constructor of the Die.
	 */
	@Test
	public void testDie() {
		die1 = new Die();
		assertTrue(die1.getFacevalue() >=1 && die1.getFacevalue() <= 6);
	}

	/**
	 * Tests the constructor that takes sides as a parameter.
	 */
	@Test
	public void testDieInt() {
		int sides = 200;
		die1 = new Die(sides);
		assertTrue(die1.getFacevalue() >=1 && die1.getFacevalue() <= sides);
	}

	/**
	 * Tests rollDie using a mock random generator.
	 */
	@Test
	public void testRollDie() {
		Random mockRand = mock(Random.class);
		when(mockRand.nextInt(6)).thenReturn(3);
		Die die = new Die(mockRand); // Sending the mockRandom to Die to be used for generating "random" numbers.
		
		die.rollDie();
		
		assertTrue(die.getFacevalue() == 3+1);
		verify(mockRand).nextInt(6); // Verify that nextInt was actually called with the parameter 6.
	}
}
