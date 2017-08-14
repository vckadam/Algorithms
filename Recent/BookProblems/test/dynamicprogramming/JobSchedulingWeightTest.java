package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JobSchedulingWeightTest {

	private JobSchedulingWeight jobSchedulingWeight;
	@Before
	public void setUp() throws Exception {
		this.jobSchedulingWeight = new JobSchedulingWeight();
	}

	@Test
	public void testGetSequence_BasicScenario() {
		char[] jobIds = {'a','b','c','d','e','f'};
		int[] startTimes = {2,1,6,4,5,7};
		int[] endTimes = {5,3,7,6,8,9};
		int[] profit = {6,5,4,5,11,2};
		List<Object[]> jobDesc = prepJobDescList(jobIds,startTimes,endTimes,profit);
		List<Character> actualJobIds = this.jobSchedulingWeight.getSequence(jobDesc);
		Collections.sort(actualJobIds);
		List<Character> expectedJobIds = Arrays.asList('a','e');
		assertEquals(expectedJobIds,actualJobIds);
		
	}
	
	@Test
	public void testGetSequence_OneJob() {
		char[] jobIds = {'a'};
		int[] startTimes = {2};
		int[] endTimes = {5};
		int[] profit = {6};
		List<Object[]> jobDesc = prepJobDescList(jobIds,startTimes,endTimes,profit);
		List<Character> actualJobIds = this.jobSchedulingWeight.getSequence(jobDesc);
		Collections.sort(actualJobIds);
		List<Character> expectedJobIds = Arrays.asList('a');
		assertEquals(expectedJobIds,actualJobIds);
		
	}
	
	@Test
	public void testGetSequence_OverlappingJobSecondMoreProfit() {
		char[] jobIds = {'a','b'};
		int[] startTimes = {2,3};
		int[] endTimes = {5,4};
		int[] profit = {6,10};
		List<Object[]> jobDesc = prepJobDescList(jobIds,startTimes,endTimes,profit);
		List<Character> actualJobIds = this.jobSchedulingWeight.getSequence(jobDesc);
		Collections.sort(actualJobIds);
		List<Character> expectedJobIds = Arrays.asList('b');
		assertEquals(expectedJobIds,actualJobIds);
		
	}
	
	@Test
	public void testGetSequence_OverlappingJobFirstMoreProfit() {
		char[] jobIds = {'a','b'};
		int[] startTimes = {2,3};
		int[] endTimes = {5,4};
		int[] profit = {16,10};
		List<Object[]> jobDesc = prepJobDescList(jobIds,startTimes,endTimes,profit);
		List<Character> actualJobIds = this.jobSchedulingWeight.getSequence(jobDesc);
		Collections.sort(actualJobIds);
		List<Character> expectedJobIds = Arrays.asList('a');
		assertEquals(expectedJobIds,actualJobIds);
		
	}
	
	private List<Object[]> prepJobDescList(char[] jobIds,int[] startTimes,int[] endTimes,int[] profit){
		List<Object[]> jobs = new ArrayList<Object[]>();
		for(int i = 0; i < jobIds.length; i++) {
			jobs.add(new Object[]{jobIds[i],startTimes[i],endTimes[i],profit[i]});
		}
		return jobs;
	}
}
