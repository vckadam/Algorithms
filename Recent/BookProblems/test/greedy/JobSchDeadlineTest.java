package greedy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JobSchDeadlineTest {

	private JobSchDeadline jobSchDeadline;
	@Before
	public void setUp() throws Exception {
		this.jobSchDeadline = new JobSchDeadline();
	}

	@Test
	public void testGetSequenceJobId_BasicScenario() {
		char[] jobIds = {'a','b','c','d'};
		int[] deadLine = {4,1,1,1};
		int[] profit = {20,10,40,30};
		List<Character> actualSequence = this.jobSchDeadline.getSequenceJobId(jobIds, deadLine, profit);
		List<Character> expectedSequence = Arrays.asList('c','a');
		assertEquals(expectedSequence,actualSequence);
	}
	
	@Test
	public void testGetSequenceJobId_ConflictingDeadLines() {
		char[] jobIds = {'a','b','c','d','e'};
		int[] deadLine = {2,1,2,1,3};
		int[] profit = {100,19,27,25,15};
		List<Character> actualSequence = this.jobSchDeadline.getSequenceJobId(jobIds, deadLine, profit);
		List<Character> expectedSequence = Arrays.asList('c','a','e');
		assertEquals(expectedSequence,actualSequence);
	}
	
	@Test
	public void testGetSequenceJobId_OneJob() {
		char[] jobIds = {'a'};
		int[] deadLine = {1};
		int[] profit = {100};
		List<Character> actualSequence = this.jobSchDeadline.getSequenceJobId(jobIds, deadLine, profit);
		List<Character> expectedSequence = Arrays.asList('a');
		assertEquals(expectedSequence,actualSequence);
	}
	
	@Test
	public void testGetSequenceJobId_NoConflictingDeadLines() {
		char[] jobIds = {'a','b','c','d','e'};
		int[] deadLine = {5,1,2,4,3};
		int[] profit = {100,19,27,25,15};
		List<Character> actualSequence = this.jobSchDeadline.getSequenceJobId(jobIds, deadLine, profit);
		List<Character> expectedSequence = Arrays.asList('b','c','e','d','a');
		assertEquals(expectedSequence,actualSequence);
	}

}
