package search;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MissingTwoNumbersTest {
	
	MissingTwoNumbers obj;
	
	@Before
	public void beforeMethod() {
		this.obj = new MissingTwoNumbers();
	}
	
	@After
	public void afterMethod() {
		this.obj = null;
	}
	
	@Test
	public void getMissingNumbersTest1() {
		int[] array = {1,2,4,6};
		int[] actual = obj.getMissingNumbers(array, 6);
		Set<Integer> actualSet = new HashSet<Integer>();
		for(int i = 0; i < actual.length; i++) actualSet.add(actual[i]);
		
		Set<Integer> expectedSet = new HashSet<Integer>(Arrays.asList(3,5));
		
		assertEquals(expectedSet.size(), actual.length);
		assertEquals(expectedSet, actualSet);
		
	}
	
	@Test
	public void getMissingNumbersTest2() {
		int[] array = {1,2,3,4,6,5,9};
		int[] actual = obj.getMissingNumbers(array, 9);
		Set<Integer> actualSet = new HashSet<Integer>();
		for(int i = 0; i < actual.length; i++) actualSet.add(actual[i]);
		
		Set<Integer> expectedSet = new HashSet<Integer>(Arrays.asList(8,7));
		
		assertEquals(expectedSet.size(), actual.length);
		assertEquals(expectedSet, actualSet);
		
	}
}
