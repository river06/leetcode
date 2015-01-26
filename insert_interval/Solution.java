/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public LinkedList<Interval> insert(LinkedList<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }
        
        // find the start point of the newInterval
        int next_idx = intervals.size();
        for(int i=0; i<intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            if(tmp.start > newInterval.start) {
                
                break;
            }
        }
        
        
        // insert the newInerval there
        
        // three cases for end point of newInterval
        // case 1: less than next start point, just insert
        
        // case 2: less than or equal to next end point, extend newInteral and insert
        
        // case 3: greater than next end point, delete the interval
    }
}