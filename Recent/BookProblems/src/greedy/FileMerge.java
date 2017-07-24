package greedy;

import java.util.PriorityQueue;
import java.util.Comparator;

public class FileMerge {
	public long getMinMergeCost(Integer[] costs) {
		if (costs == null || costs.length == 0) return 0;
		PriorityQueue<Long> pq = new PriorityQueue<Long>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return o1.longValue() <= o2.longValue() ? -1 : 1;
			}
			
		});
		
		for (Integer cost : costs) {
			 if (cost != null && cost.longValue() > 0) {
				pq.add(cost.longValue());
			 }
		}
		
		while(pq.size() > 1) {
			long sum = pq.poll() + pq.poll();
			pq.add(sum);
		}
		
		return !pq.isEmpty() ? pq.poll() : 0;
	}
}
