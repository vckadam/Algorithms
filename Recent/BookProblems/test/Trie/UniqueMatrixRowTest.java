package Trie;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UniqueMatrixRowTest {

	UniqueMatrixRow uniqueMatrixRow;
	@Before
	public void setUp() throws Exception {
		this.uniqueMatrixRow = new UniqueMatrixRow();
	}

	@Test
	public void testGetUniqueMatrixRowIndices_BasicScenario() {
		int[][] matrix = {{0,1,0,0,1},{1,0,1,1,0},{0,1,0,0,1},{1,1,1,0,0}};
		List<Integer> actual = this.uniqueMatrixRow.getUniqueMatrixRowIndices(matrix);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(0,1,3));
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetUniqueMatrixRowIndices_AllRowsSame() {
		int[][] matrix = {{0,1,0,0,1},{0,1,0,0,1},{0,1,0,0,1},{0,1,0,0,1}};
		List<Integer> actual = this.uniqueMatrixRow.getUniqueMatrixRowIndices(matrix);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(0));
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetUniqueMatrixRowIndices_AllRowsDifferent() {
		int[][] matrix = {{0,1,0},{1,0,1},{1,1,0}};
		List<Integer> actual = this.uniqueMatrixRow.getUniqueMatrixRowIndices(matrix);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(0,1,2));
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetUniqueMatrixRowIndices_TwoUnique() {
		int[][] matrix = {{0,1,0},{1,0,1},{0,1,0},{1,0,1},{0,1,0},{1,0,1}};
		List<Integer> actual = this.uniqueMatrixRow.getUniqueMatrixRowIndices(matrix);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(0,1));
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetUniqueMatrixRowIndices_OnlyOneRow() {
		int[][] matrix = {{0,1,0}};
		List<Integer> actual = this.uniqueMatrixRow.getUniqueMatrixRowIndices(matrix);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(0));
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetUniqueMatrixRowIndices_OnlyOneRowOneElement() {
		int[][] matrix = {{0}};
		List<Integer> actual = this.uniqueMatrixRow.getUniqueMatrixRowIndices(matrix);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(0));
		assertEquals(expected,actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUniqueMatrixRowIndices_EmptyArray() {
		int[][] matrix = {};
		this.uniqueMatrixRow.getUniqueMatrixRowIndices(matrix);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetUniqueMatrixRowIndices_NullArray() {
		int[][] matrix = null;
		this.uniqueMatrixRow.getUniqueMatrixRowIndices(matrix);
	}
}
