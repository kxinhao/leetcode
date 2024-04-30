/**
 * LeetCode 57 Insert Interval (Medium)
 * brute force impl, failed at non overlap new interval test
 * 2nd try ans derived from solutions, using arraylist and single pass index tracking operations
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        // add preintersect intervals
        while (i<intervals.length && intervals[i][1]<newInterval[0]) ans.add(intervals[i++]);
        // add intersecting intervals
        while (i<intervals.length && intervals[i][0]<=newInterval[1]) {
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i][1]);
            i++;
        }
        ans.add(new int[]{start,end});
        // add post intersect intervals
        while(i<intervals.length) ans.add(intervals[i++]);
        return ans.toArray(new int [ans.size()][2]);
    }
}
