package point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClosestTwo {
	
	public Point[] getTwoClosest(Point[] points) {
		if(points != null && points.length > 0) {
			Comparator<Point> comp = new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					if(o1 == null) return 1;
					else if(o2 == null) return -1;
					else if(o1.x != o2.x) return  o1.x - o2.x;
					else return o1.y - o2.y;
				}
				
				
			};
			Arrays.sort(points, comp);
			int len = removeDuplicates(points);
			return helper(points, 0, len-1);
		} else
			return null;
	}
	
	private int removeDuplicates(Point[] points) {
		if(points.length <= 1) return points.length;
		int i = 0, j = 1;
		while(j < points.length && points[j] != null) {
			if(!isSame(points[i], points[j])) swap(points, ++i , j);
			j++;
		}
		return i+1;
	}
	
	private boolean isSame(Point p1, Point p2) {
		return p1.x == p2.x && p1.y == p2.y;
	}
	
	private void swap(Point[] points, int i , int j) {
		Point temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}
	private Point[] helper(Point[] points, int l, int n) {
		if(l > n) return null;
		int size = n - l + 1, mid = l + (n-l)/2;
		if(size <= 1) 
			return null;
		if(size  <= 3) {
			return getMinBruteForce(points,l,n);
		}
		Point[] minDistPoints = new Point[2];
		Point[] leftPoints = helper(points, l, mid);
		Point[] rightPoints = helper(points, mid+1, n);
		double leftDist = getDistance(leftPoints[0],leftPoints[1]);
		double rightDist = getDistance(rightPoints[0],rightPoints[1]);
		double minDist = Math.min(leftDist, rightDist);
		if(leftDist <= rightDist) {
			minDistPoints = leftPoints;
		} else {
			minDistPoints = rightPoints;
		}
		List<Point> strip = new ArrayList<Point>();
		for(int i = l; i <= n; i++) {
			if(Math.abs(points[i].x - points[mid].x) < minDist) {
				strip.add(points[i]);
			}
		}
		if(strip.size() > 1) {
			Comparator<Point> yComp = new Comparator<Point>() {
	
				@Override
				public int compare(Point o1, Point o2) {
					return o1.y - o2.y;
				}
				
			};
			Collections.sort(strip, yComp);
			Point[] stripPoints = getMinDistStripPoints(strip, minDist);
			if(stripPoints != null) {
				minDistPoints = stripPoints;
			}
		}
		return minDistPoints;
	}
	
	private Point[] getMinDistStripPoints(List<Point> strip, double dist) {
		Point[] minDistPoints = new Point[2];
		double minDist = dist;
		for(int i = 0; i < strip.size()-1; i++) {
			for(int j = i + 1; j < strip.size() && Math.abs(strip.get(i).y - strip.get(j).y) < minDist; j++) {
				double currDist;
				if((currDist = getDistance(strip.get(i), strip.get(j))) < minDist) {
					minDist = currDist;
					minDistPoints[0] = strip.get(i);
					minDistPoints[1] = strip.get(j);
				}
			}
		}
		return (minDistPoints[0] != null) ? minDistPoints : null;
	}
	
	private Point[] getMinBruteForce(Point[] points, int left, int right) {
		double min = Double.MAX_VALUE;
		Point[] currPoints = new Point[2];
		for(int i = left; i <= right-1; i++) {
			if(points[i] != null) {
				for(int j = i+1; j <= right; j++) {
					if(points[j] != null) {
						double currDist;
						if((currDist = getDistance(points[i],points[j])) < min) {
							min = currDist;
							currPoints[0] = points[i];
							currPoints[1] = points[j];
						}
					}
				}
			}
		}
		return (currPoints[0] != null) ? currPoints : null;
	}
	
	private double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.x-p1.x, 2)+Math.pow(p2.y-p1.y, 2));
	}
}
