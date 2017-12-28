package string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrintStringWithSpaceTest {

	private PrintStringWithSpace  printStringWithSpace;
	
	@Before
	public void setUp() {
		this.printStringWithSpace = new PrintStringWithSpace();
	}
	
	@After
	public void tearDown() {
		this.printStringWithSpace = null;
	}
	
	@Test
	public void testGetAllCombo_OddLengthString() {
		String[] strA = {"ABC", "A BC", "A B C", "AB C"};
		Set<String> expected = new HashSet<String>(Arrays.asList(strA));
		List<String> actualList = this.printStringWithSpace.getAllCombo("ABC");
		Set<String> actual = populateSet(actualList);
		assertEquals(expected.size(), actualList.size());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetAllCombo_EvenLengthString() {
		String[] strA = {"ABCD", "A BCD", "A B CD", "A B C D", "A BC D", "AB CD", "AB C D", "ABC D"};
		Set<String> expected = new HashSet<String>(Arrays.asList(strA));
		List<String> actualList = this.printStringWithSpace.getAllCombo("ABCD");
		Set<String> actual = populateSet(actualList);
		assertEquals(expected.size(), actualList.size());
		assertEquals(expected, actual);
	}

	public Set<String> populateSet(List<String> list) {
		Set<String> set = new HashSet<String>();
		for(String str : list) 
			set.add(str);
		return set;
	}
}
