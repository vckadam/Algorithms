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
		int ret = right;
		while(left <= right) {
			int mid = (left + right)/2;
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
		int count = 1, currStatus = 0;
		int i = 0;
		while(i < jobTimes.length) {
			if(currStatus + jobTimes[i] > time) {
				count++;
				currStatus = 0;
			} else {
				currStatus += jobTimes[i++];
			}
		}
		return count <= workers;
	}
}
