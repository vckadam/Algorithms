package heap;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrainScheduleTest {

	private TrainSchedule trainSchedule;
	
	@Before
	public void setUp() throws Exception {
		this.trainSchedule = new TrainSchedule();
	}

	@After
	public void tearDown() throws Exception {
		this.trainSchedule = null;
	}

	@Test
	public void testMinNumOfPlatform() {
		String[] arrival = {"9:00",  "9:40", "9:50",  "11:00", "15:00", "18:00"};
		String[] departure = {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"};
		Integer actual = this.trainSchedule.minNumOfPlatform(arrival, departure);
		assertEquals(3, actual.intValue());
	}

}
