import static org.junit.Assert.*;

import org.junit.Test;


public class AGameOfReductionNewTest {

	@Test
	public void test() {
		AGameOfReductionNew gameNew = new AGameOfReductionNew();
		assertEquals(709, gameNew.getAllIndex(800)[0]);
	}

}
