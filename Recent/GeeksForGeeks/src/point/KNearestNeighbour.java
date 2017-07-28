package point;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


public class KNearestNeighbour {
	public Point[] getNeighbourForOrigin(Point[] points, int k) {
		if(points != null && k > 0) {
			PriorityQueue<Point> minHeap = new PriorityQueue<Point>(new Comparator<Point>(){
				public int compare(Point p1, Point p2) {
					double dist1 = getDistance(p1);
					double dist2 = getDistance(p2);
					if(dist1 < dist2)  // maintains relative order by avoiding equal
						return -1;
					else 
						return 1;
				}
			});
			Set<String> set = new HashSet<String>(); // avoids duplicate
			set.add("0 0"); // avoids origin
			for(Point point : points) {
				if(point != null && !set.contains(point.toString())) {
					set.add(point.toString());
					minHeap.add(point);
				}
			}
			Point[] neighbours = new Point[Math.min(k, minHeap.size())];
			for(int i = 0; i < neighbours.length; i++) {
				neighbours[i] = minHeap.poll();
			}
			return neighbours;
		}
		else 
			return null;
	}
	public double getDistance(Point point) {
		return Math.sqrt(Math.pow(point.x, 2)+Math.pow(point.y, 2));
	}
}
