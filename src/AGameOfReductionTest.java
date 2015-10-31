import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;


public class AGameOfReductionTest {

	@Test
	public void testTest() {
		assertEquals(true, true);
	}
	

	
	@Test
	public void testHeight()
	{
		AGameOfReduction game = new AGameOfReduction();
		
		assertEquals(2, game.getSumHeight(399));
	}
}
