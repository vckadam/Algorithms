package array;

public class JobTimeSchedule {
	public int getMinTimeToFinish(int[] jobTimes, int workers) {
		if(jobTimes == null || workers <= 0)
			throw new IllegalArgumentException("Illegal Argument");
		int max = 0, sum = 0;
		for(int i = 0; i < jobTimes.length; i++) {
			max = Math.max(max, jobTimes[i]);
			sum += jobTimes[i];
		}
		return helper(jobTimes,workers,max,sum);
	}
	
	public int helper(int[] jobTimes, int workers, int left, int right) {
		int mid = left + (right-left)/2;
		int ret = right;
		while(left <= right) {
			if(isPossible(jobTimes,workers,mid)) {
				ret = Math.min(ret, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ret;
	}
	
	public boolean isPossible(int[] jobTimes, int workers, int time) {
		int count = 0, currStatus = 0;
		for(int i = 0; i < jobTimes.length; i++) {
			currStatus += jobTimes[i];
			if(currStatus > time) {
				i--;
				currStatus = 0;
				count++;
			} else {
				currStatus += jobTimes[i];
			}
		}
		return count <= workers;
	}
}
