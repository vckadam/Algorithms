/*
539. Minimum Time Difference
Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
*/
public class Solution {
    class Time {
        int hours;
        int mins;
        public Time(int hours, int mins) {
            this.hours = hours;
            this.mins = mins;
        }
    }
    public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Time> pq = new PriorityQueue<Time>((t1,t2)-> (t1.hours == t2.hours)?t1.mins-t2.mins:t1.hours-t2.hours);
        int diff = Integer.MAX_VALUE;
        for(String str : timePoints) {
            String[] time = str.split(":");
            pq.add(new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1])));
        }
        Time prev = pq.poll(), first = prev, curr = null;
        int remaining = getDifference(new Time(0,0),first);
        while(!pq.isEmpty()) {
            curr = pq.poll();
            diff = Math.min(diff, getDifference(prev, curr));
            prev = curr;
        }
        remaining += getDifference(curr, new Time(24,0));
        return Math.min(diff,remaining);
    }
    public int getDifference(Time t1, Time t2) {
        int diffHours = t2.hours - t1.hours;
        int diffMin = t2.mins - t1.mins;
        return diffHours * 60 + diffMin;
    }
    
}