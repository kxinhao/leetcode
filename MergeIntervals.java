/**
 * Leetcode 56 Merge Intervals (Medium)
 * Sort by start val and merge
 * must sort to prevent any missed overlaps of intervals at end of array and ensure condition 
 * that curr[0]<=interval[0]
 * TC O(N log(N)) log linear TC
 */
// 3rd impl with lambda comparator from soln and merge conditions from prior qns
// eg. [1,10] at [[2,3],[4,5],[6,7],[8,9],[1,10]]

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        // lambda compare, collection and var names as params
        // the correct way to implement compareison in Java 7 and up would be 
        // Integer.compare(i1[0],i2[0]) instead of i1[0] - i2[0] to prevent large neg values overflow
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0],i2[0]));
        List<int[]> ans = new ArrayList<int[]>(intervals.length);
        int[] curr = intervals[0];
        ans.add(curr);
        // curr end time will be compared for merge if subsequent intervals have start time before
        for(int[] interval : intervals) {
            // curr end is larger than interval start means that curr and interval intersect
            if(interval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], interval[1]);
            }
            // if no intersect, add this interval to ans and consider for merges
            else {
                curr = interval;
                ans.add(curr);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
