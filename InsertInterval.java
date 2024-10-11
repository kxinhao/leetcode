/**
 * LeetCode 57 Insert Interval (Medium)
 * 3 cases to account for, pre intersect of newInterval, post intersect and intersecting intervals
 * ##brute force impl, failed at non overlap new interval test
 */

// 5th soln
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
            else if(newInterval[0]>interval[1]) {
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
