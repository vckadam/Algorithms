package ternarysearchtree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AutoCompleteTSTTest {

	private AutoCompleteTST autoCompleteTST;
	private final static String[] words = {"cat","cats","up","bug"};
	
	@Before
	public void setUp() throws Exception {
		this.autoCompleteTST = new AutoCompleteTST();
		this.autoCompleteTST.createDist(words);
	}

	@Test
	public void testContains_BasicScenario() {
		assertTrue(this.autoCompleteTST.contains("cat"));
	}
	
	@Test
	public void testContains_WordNotExist() {
		assertFalse(this.autoCompleteTST.contains("zk"));
	}
	
	@Test
	public void testContains_NullInput() {
		assertFalse(this.autoCompleteTST.contains(null));
	}

	@Test
	public void testContains_EmptyString() {
		assertFalse(this.autoCompleteTST.contains(""));
	}
	
	@Test
	public void testContains_OneDistWord() {
		assertFalse(this.autoCompleteTST.contains("catm"));
	}
}
