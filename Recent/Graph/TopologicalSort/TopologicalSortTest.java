package TopologicalSort;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopologicalSortTest {

	TopologicalSort tp;
	
	@Before
	public void beforeTest() {
		tp = new TopologicalSort();
	}
	
	@After
	public void afterTest() {
		tp = null;
	}
	@Test
	public void getTopologicalSortTest() {
		int[][] edges = {{5,11},{7,11},{7,8},{3,8},{3,10},{11,2},{11,9},{11,10},{8,9}};
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(5, 7, 3, 11, 8, 2, 9, 10));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(3, 5, 7, 8, 11, 2, 9, 10));
		List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(5, 7, 3, 8, 11, 10, 9, 2));
		List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(7, 5, 11, 3, 10, 8, 9, 2));
		List<Integer> list5 = new ArrayList<Integer>(Arrays.asList(5, 7, 11, 2, 3, 8, 9, 10));
		List<Integer> list6 = new ArrayList<Integer>(Arrays.asList(3, 7, 8, 5, 11, 10, 2, 9));
		Set<String> set = new HashSet<String>();
		set.add(list1.toString()); set.add(list2.toString()); set.add(list3.toString()); 
		set.add(list4.toString()); set.add(list5.toString());
		set.add(list6.toString());
		assertTrue(set.contains(tp.getTopologicalSort(edges).toString()));
		assertTrue(set.contains(tp.getTopologicalSort(edges).toString()));
		assertTrue(set.contains(tp.getTopologicalSort(edges).toString()));
		assertTrue(set.contains(tp.getTopologicalSort(edges).toString()));
		assertTrue(set.contains(tp.getTopologicalSort(edges).toString()));
	}
}
