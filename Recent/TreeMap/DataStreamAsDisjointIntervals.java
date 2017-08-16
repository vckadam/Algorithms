/*
352. Data Stream as Disjoint Intervals

Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?

*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    TreeMap<Integer,Interval> hm;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        hm = new TreeMap<Integer,Interval>();
    }
    
    public void createInterval(int val, TreeMap<Integer,Interval> hm) {
        Interval currInt = new Interval(val,val);
        hm.put(val, currInt);
    }
    
    public void updateBefore(int val, TreeMap<Integer,Interval> hm, Interval before) {
        hm.remove(before.end);
        before.end = val;
        hm.put(val,before);
        hm.put(before.start,before);
    }
    
    public void updateAfter(int val, TreeMap<Integer,Interval> hm, Interval after) {
        hm.remove(after.start);
        after.start = val;
        hm.put(val,after);
        hm.put(after.end,after);
    }
    
    public void addNum(int val) {
        Map.Entry<Integer,Interval> ceiling = hm.ceilingEntry(val);
        Map.Entry<Integer,Interval> floor = hm.floorEntry(val);
        if(ceiling == null && floor == null) {
            createInterval(val,hm);
            return;
        }
        else if(ceiling == null && floor != null) {
            Interval before = (Interval)floor.getValue();
            if(before.end == val || (val > before.start && val < before.end)) 
                return;
            else if(before.end + 1 == val) {
                updateBefore(val,hm,before);
            } else {
                createInterval(val,hm);
            }
            return;
        }
        else if(floor == null && ceiling != null) {
            Interval after = (Interval)ceiling.getValue();
            if(after.start == val || (val > after.start && val < after.end))
                return;
            else if(after.start - 1 == val) {
                updateAfter(val,hm,after);
            } else {
                createInterval(val,hm);
            }
            return;
        }
        else {
            Interval after = (Interval)ceiling.getValue();
            Interval before = (Interval)floor.getValue();
            if((val > after.start && val < after.end) || 
              (val > before.start && val < before.end)) 
                return;
            if(after.start - 1 == val) {
                updateAfter(val,hm,after);
            }
            if(before.end + 1 == val) {
                updateBefore(val,hm,before);
            }
            if(after.start == before.end) {
                hm.remove(after.start);
                hm.remove(before.end);
                before.end = after.end;
                hm.put(before.start, before);
                hm.put(before.end, before);
            } else {
                if(before.end != val && after.start != val) {
                    createInterval(val,hm);
                }
            }
            
        }
    }
    
    public List<Interval> getIntervals() {
        Set<Interval> set = new HashSet<Interval>();
        List<Interval> ret = new ArrayList<Interval>();
        for(Interval interval : hm.values()) {
            if(!set.contains(interval)) {
                set.add(interval);
                ret.add(interval);
            }
        }
        return ret;
        //return new ArrayList<Interval>(new HashSet<Interval>(hm.values()));
        // treeMap makes sure that keys are in ascending order.
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */