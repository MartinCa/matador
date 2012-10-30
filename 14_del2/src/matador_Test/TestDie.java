package matador_Test;

import static org.junit.Assert.*;

import matador_BusinessLogic.*;

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
		die1 = new Die();
		for (int i = 0; i <= 100; i++) {
			die1.rollDie();
			assertTrue(die1.getFacevalue() >=1 && die1.getFacevalue() <= 6);
		}
	}

	@Test
	public void testGetFacevalue() {
		die1 = new Die();
		assertTrue(die1.getFacevalue() >=1 && die1.getFacevalue() <= 6);
	}

}
