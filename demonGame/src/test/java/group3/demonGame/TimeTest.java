package group3.demonGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	private GameManager gm;

    private Time TimeUnderTest;

	@Before
	public void setUp() {
		gm = new GameManager();
		TimeUnderTest= new Time(gm);
	}


	/**
	 * check seconds to minute conversion
	 */
	@Test
	public void testGetMinutes() {
		int a=TimeUnderTest.getMinutes(60);
		int b=TimeUnderTest.getMinutes(90);
		int c=TimeUnderTest.getMinutes(0);

		assertEquals( 1, a);
		assertEquals( 1, b);
		assertEquals( 0, c);

	}

	/**
	 * check seconds to seconds - minutes conversion
	 */
	@Test
	public void testGetSeconds() {
		TimeUnderTest.getMinutes(60);
		int a1=TimeUnderTest.getSeconds();
		TimeUnderTest.getMinutes(90);
		int b1=TimeUnderTest.getSeconds();
		TimeUnderTest.getMinutes(0);
		int c1=TimeUnderTest.getSeconds();
		assertEquals( 0, a1);
		assertEquals( 30, b1);
		assertEquals( 0, c1);
	}

	

}
