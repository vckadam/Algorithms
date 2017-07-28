package search;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OperationOfTwoInArrayTest {
	
	OperationOfTwoInArray obj;
	
	@Before
	public void beforeMethod() {
		this.obj = new OperationOfTwoInArray();
	}
	
	@After
	public void afterMethod() {
		this.obj = null;
	}
	
	/** Duplicate elements in the array. */
	@Test
	public void sumOfTwoInArrayTest1() {
		int[] array = new int[]{0,1,1,4,4};
		List<List<Integer>> actualList = this.obj.sumOfTwoInArray(array);
		Set<List<Integer>> actualSet = new HashSet<List<Integer>>(actualList);
		Set<List<Integer>> expectedSet = new HashSet<List<Integer>>();
		List<Integer> expected1 = new ArrayList<Integer>(Arrays.asList(0,1,2));
		List<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(0,3,4));
		expectedSet.add(expected1);
		expectedSet.add(expected2);
	    assertEquals(expectedSet, actualSet);
	}
	
	/** Same sum with different indices. */
	@Test
	public void sumOfTwoInArrayTest2() {
		int[] array = new int[]{0,1,1,4,4,5};
		List<List<Integer>> actualList = this.obj.sumOfTwoInArray(array);
		Set<Set<Integer>> actualSet = new HashSet<Set<Integer>>();
		for(List<Integer> list : actualList) {
			Set<Integer> currSet = new HashSet<Integer>(list);
			actualSet.add(currSet);
		}
		Set<Set<Integer>> expectedSet = new HashSet<Set<Integer>>();
		expectedSet.add(new HashSet<Integer>(Arrays.asList(0,2,1)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(3,4,0)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(1,3,5)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(3,2,5)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(1,4,5)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(2,4,5)));
		assertEquals(expectedSet.size(), actualList.size());
	    assertEquals(expectedSet, actualSet);
	}
	
	/** Negative elements in the array.*/
	@Test
	public void sumOfTwoInArrayTest3() {
		int[] array = new int[]{-2,1,0,-1,2};
		List<List<Integer>> actualList = this.obj.sumOfTwoInArray(array);
		Set<Set<Integer>> actualSet = new HashSet<Set<Integer>>();
		for(List<Integer> list : actualList) {
			Set<Integer> currSet = new HashSet<Integer>(list);
			actualSet.add(currSet);
		}
		Set<Set<Integer>> expectedSet = new HashSet<Set<Integer>>();
		expectedSet.add(new HashSet<Integer>(Arrays.asList(0,4,2)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(2,1,3)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(0,1,3)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(1,3,4)));
		assertEquals(expectedSet.size(), actualList.size());
	    assertEquals(expectedSet, actualSet);
	}
	
	/** Desired combination is not possible. */
	@Test
	public void sumOfTwoInArrayTest4() {
		int[] array = new int[]{1,4,9,16};
		List<List<Integer>> actualList = this.obj.sumOfTwoInArray(array);
		List<List<Integer>> expectedEmptyList = new ArrayList<List<Integer>>();
	    assertEquals(expectedEmptyList, actualList);
	}
	
	/** One possible result. */
	@Test
	public void sumOfSquareOfTwoInArrayTest1() {
		int[] array = new int[]{1,2,5,4,3};
		List<List<Integer>> actualList = this.obj.sumOfSquareOfTwoInArray(array);
		Set<Set<Integer>> actualSet = new HashSet<Set<Integer>>();
		for(List<Integer> list : actualList) {
			actualSet.add(new HashSet<Integer>(list));
		}
		Set<Set<Integer>> expectedSet = new HashSet<Set<Integer>>();
		expectedSet.add(new HashSet<Integer>(Arrays.asList(2,3,4)));
		assertEquals(expectedSet, actualSet);
	}
	
	/** multiple possible result because of duplicate elements. */
	@Test
	public void sumOfSquareOfTwoInArrayTest2() {
		int[] array = new int[]{1,2,5,4,3,3};
		List<List<Integer>> actualList = this.obj.sumOfSquareOfTwoInArray(array);
		Set<Set<Integer>> actualSet = new HashSet<Set<Integer>>();
		for(List<Integer> list : actualList) {
			actualSet.add(new HashSet<Integer>(list));
		}
		Set<Set<Integer>> expectedSet = new HashSet<Set<Integer>>();
		expectedSet.add(new HashSet<Integer>(Arrays.asList(2,3,4)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(2,3,5)));
		assertEquals(expectedSet, actualSet);
	}
	
	/** multiple possible result because of duplicate elements. */
	@Test
	public void sumOfSquareOfTwoInArrayTest3() {
		int[] array = new int[]{0,3,3,2,2,0,5,6};
		List<List<Integer>> actualList = this.obj.sumOfSquareOfTwoInArray(array);
		Set<Set<Integer>> actualSet = new HashSet<Set<Integer>>();
		for(List<Integer> list : actualList) {
			actualSet.add(new HashSet<Integer>(list));
		}
		Set<Set<Integer>> expectedSet = new HashSet<Set<Integer>>();
		expectedSet.add(new HashSet<Integer>(Arrays.asList(0,1,2)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(1,5,2)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(0,3,4)));
		expectedSet.add(new HashSet<Integer>(Arrays.asList(3,4,5)));
		assertEquals(expectedSet, actualSet);
	}
}
