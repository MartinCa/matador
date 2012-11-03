package matador.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import matador.business_logic.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDie {
	Die die1;	
	Die die2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDie() {
		die1 = new Die();
		assertTrue(die1.getFacevalue() >=1 && die1.getFacevalue() <= 6);
	}

	@Test
	public void testDieInt() {
		int sides = 200;
		die1 = new Die(sides);
		assertTrue(die1.getFacevalue() >=1 && die1.getFacevalue() <= sides);
	}

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
