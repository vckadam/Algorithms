package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import problem.AutocompleteSystem;

public class AutocompleteSystemTest {

	private AutocompleteSystem autocompleteSystem;
	

	@Test
	public void testInput_FirstCharI() {
		String[] sentenses = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		this.autocompleteSystem = new AutocompleteSystem(sentenses,times);
		List<String> actualList = this.autocompleteSystem.input('i');
		List<String> expectedList = Arrays.asList("i love you", "island","i love leetcode");
		assertEquals(expectedList,actualList);
	}
	
	@Test
	public void testInput_SecondCharSpace() {
		String[] sentenses = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		this.autocompleteSystem = new AutocompleteSystem(sentenses,times);
		this.autocompleteSystem.input('i');
		List<String> actualList = autocompleteSystem.input(' ');
		List<String> expectedList = Arrays.asList("i love you","i love leetcode");
		assertEquals(expectedList,actualList);
	}
	
	@Test
	public void testInput_ThirdCharA() {
		String[] sentenses = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		this.autocompleteSystem = new AutocompleteSystem(sentenses,times);
		this.autocompleteSystem.input('i');
		this.autocompleteSystem.input(' ');
		List<String> actualList = autocompleteSystem.input('a');
		List<String> expectedList = Arrays.asList();
		assertEquals(expectedList,actualList);
	}
	
	@Test
	public void testInput_LastChar() {
		String[] sentenses = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		this.autocompleteSystem = new AutocompleteSystem(sentenses,times);
		this.autocompleteSystem.input('i');
		this.autocompleteSystem.input(' ');
		this.autocompleteSystem.input('a');
		List<String> actualList = autocompleteSystem.input('#');
		List<String> expectedList = Arrays.asList();
		assertEquals(expectedList,actualList);
	}
	
	
	@Test
	public void testInput_SecondArrayFirstCharT() {
		String[] sentenses = {"to","tea","ted","ten","a","in","inn"};
		int[] times = {7,3,4,12,15,5,9};
		this.autocompleteSystem = new AutocompleteSystem(sentenses,times);
		List<String> actualList = autocompleteSystem.input('t');
		List<String> expectedList = Arrays.asList("ten","to","ted");
		assertEquals(expectedList,actualList);
	}
	
	@Test
	public void testInput_SecondArraySecondCharE() {
		String[] sentenses = {"to","tea","ted","ten","a","in","inn"};
		int[] times = {7,3,4,12,15,5,9};
		this.autocompleteSystem = new AutocompleteSystem(sentenses,times);
		autocompleteSystem.input('t');
		List<String> actualList = autocompleteSystem.input('e');
		List<String> expectedList = Arrays.asList("ten","ted","tea");
		assertEquals(expectedList,actualList);
	}
	
	

}
