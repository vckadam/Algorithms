package heap;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TrainTime {
	int startHH, startMM, endHH, endMM;
	public TrainTime(int startHH, int startMM, int endHH, int endMM) {
		this.startHH = startHH;
		this.endHH = endHH;
		this.startMM = startMM;
		this.endMM = endMM;
	}
	public String toString() {
		return "--"+startHH+":"+startMM+"--"+endHH+":"+endMM+"--";
	}
}
public class TrainSchedule {
	public Integer minNumOfPlatform(String[] arrival, String[] departure) {
		if(arrival != null && departure != null && 
				arrival.length == departure.length) {
			Comparator<TrainTime> comp = new Comparator<TrainTime>() {
				@Override
				public int compare(TrainTime o1, TrainTime o2) {
					if(o1.endHH != o2.endHH) return o1.endHH - o2.endHH;
					else return o1.endMM - o2.endMM;
				}
				
			};
			PriorityQueue<TrainTime> pq = new PriorityQueue<TrainTime>(comp);
			List<TrainTime> list = new ArrayList<TrainTime>();
			for(int i = 0; i < arrival.length; i++) {
				if(arrival[i] != null && departure[i] != null) {
					String[] start = arrival[i].split(":");
					String[] end = departure[i].split(":");
					int startHH = Integer.valueOf(start[0]);
					int startMM = Integer.valueOf(start[1]);
					int endHH = Integer.valueOf(end[0]);
					int endMM = Integer.valueOf(end[1]);
					if(startHH >= 0 && startHH <= 23 && endHH >= 0 && endHH <= 23 &&
					   startMM >= 0 && startMM <= 59 && endMM >= 0 && endMM <= 59) {
						list.add(new TrainTime(startHH,startMM, endHH, endMM));
					}
				}
			}
			Collections.sort(list,comp);
			System.out.println(list.toString());
			for(TrainTime time : list) {
				if(pq.isEmpty()) pq.add(time);
				else {
					TrainTime top = pq.peek();
					if(time.startHH > top.endHH || time.startHH == top.endHH && time.startMM > top.endMM) {
						top = pq.poll();
						top.endHH = time.endHH;
						top.endMM = time.endMM;
						pq.add(top);
					} else {
						pq.add(time);
					}
				}
			}
			return pq.size();
			
		}
		else return null;
	}
}
