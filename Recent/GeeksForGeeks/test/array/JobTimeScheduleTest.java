package array;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JobTimeScheduleTest {

	private JobTimeSchedule jobTimeSchedule;
	@Before
	public void setUp() throws Exception {
		this.jobTimeSchedule = new JobTimeSchedule();
	}

	@Test(timeout = 3000)
	public void testGetMinTimeToFinish_BasicScenario() {
		int[] jobTimes = {10, 7, 8, 12, 6, 8};
		int workers = 4;
		assertEquals(15, this.jobTimeSchedule.getMinTimeToFinish(jobTimes, workers));
		
	}

}
