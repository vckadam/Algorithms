package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problem.KillProcess;

public class KillProcessTest {
	
	KillProcess killProcess;
	
	@Before
	public void beforeMethod() {
		this.killProcess = new KillProcess();
	}
	
	@After
	public void afterMethod() {
		this.killProcess = null;
	}
	
	@Test
	public void getKilledProcessTest1() {
		List<Integer> pid = Arrays.asList(1,3,10,5);
		List<Integer> ppid = Arrays.asList(3,0,5,3);
		List<Integer> actualList = this.killProcess.getKilledProcesses(pid, ppid, 5);
		
		Set<Integer> actualSet = new HashSet<Integer>();
		for(Integer num : actualList) {
			actualSet.add(num);
		}
		Set<Integer> expectedSet = new HashSet<Integer>(Arrays.asList(5,10));
		assertEquals(expectedSet.size(), actualList.size());
		assertEquals(expectedSet, actualSet);
	}
	
	@Test
	public void getKilledProcessTest2() {
		List<Integer> pid = Arrays.asList(1,2,3,4,5,6,9,10,11,7,8,12,13,14,15);
		List<Integer> ppid = Arrays.asList(0,1,1,2,2,2,3,3,3,5,5,10,10,13,13);
		List<Integer> actualList = this.killProcess.getKilledProcesses(pid, ppid, 5);
		
		Set<Integer> actualSet = new HashSet<Integer>();
		for(Integer num : actualList) {
			actualSet.add(num);
		}
		Set<Integer> expectedSet = new HashSet<Integer>(Arrays.asList(5,7,8));
		assertEquals(expectedSet.size(), actualList.size());
		assertEquals(expectedSet, actualSet);
	}
	
	@Test
	public void getKilledProcessTest3() {
		List<Integer> pid = Arrays.asList(1,2,3,4,5,6,9,10,11,7,8,12,13,14,15);
		List<Integer> ppid = Arrays.asList(0,1,1,2,2,2,3,3,3,5,5,10,10,13,13);
		List<Integer> actualList = this.killProcess.getKilledProcesses(pid, ppid, 3);
		
		Set<Integer> actualSet = new HashSet<Integer>();
		for(Integer num : actualList) {
			actualSet.add(num);
		}
		Set<Integer> expectedSet = new HashSet<Integer>(Arrays.asList(3,9,10,11,12,13,14,15));
		assertEquals(expectedSet.size(), actualList.size());
		assertEquals(expectedSet, actualSet);
	}
	
	@Test
	public void getKilledProcessTest4() {
		List<Integer> pid = Arrays.asList(1,2,3,4,5,6,9,10,11,7,8,12,13,14,15);
		List<Integer> ppid = Arrays.asList(0,1,1,2,2,2,3,3,3,5,5,10,10,13,13);
		List<Integer> actualList = this.killProcess.getKilledProcesses(pid, ppid, 25);
		
		assertEquals(null, actualList);
	}
}
