/**
 * LeetCode 57 Insert Interval (Medium)
 * 3 cases to account for, pre intersect of newInterval, post intersect and intersecting intervals
 * ##brute force impl, failed at non overlap new interval test
 * 2nd try ans derived from solutions, using arraylist and single pass index tracking operations
 * 3rd soln with input mutation
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        // add preintersect intervals (new interval starts after interval ends)
        while (i<intervals.length && intervals[i][1]<newInterval[0]) ans.add(intervals[i++]);
        // add intersecting intervals by merging to lowest start and highest end
        // (interval starts before end of new interval)
        while (i<intervals.length && intervals[i][0]<=newInterval[1]) {
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i][1]);
            i++;
        }
        ans.add(new int[]{start,end});
        // add post intersect intervals
        // (interval starts after end of new interval)
        while(i<intervals.length) ans.add(intervals[i++]);
        return ans.toArray(new int [ans.size()][2]);
    }
}

// input mutation soln
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int[]interval : intervals) {
            // newInterval before interval slot, insert newInterval and replace with interval value
            if(newInterval[1]<interval[0]) {
                ans.add(newInterval);
                newInterval = interval;
            }
            // interval before newInterval, insert interval slot
            else if(interval[1]<newInterval[0]) {
                ans.add(interval);
            }
            else {
            // eval overlapping slots to get merged slot values
            // newInterval[1]>=interval[0] && interval[1]>=newInterval[0]
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        ans.add(newInterval);

        return ans.toArray(new int[ans.size()][]);

    }
}
