/**
 * Leetcode 56 Merge Intervals (Medium)
 * Sort by start val and merge
 * must sort to prevent any missed overlaps of intervals at end of array and ensure condition 
 * that prev[0]<=curr[0]
 * TC O(N log(N)) log linear TC
 */
// 1st impl with lambda comparator from soln and merge conditions from prior qns
// eg. [1,10] at [[2,3],[4,5],[6,7],[8,9],[1,10]]

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        // lambda compare, collection and var names as params
        // the correct way to implement compareison in Java 7 and up would be 
        // Integer.compare(i1[0],i2[0]) instead of i1[0] - i2[0] to prevent large neg values overflow
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0],i2[0]));
        List<int[]> ans = new ArrayList<int[]>(intervals.length);
        int[] prev = intervals[0];
        ans.add(prev);
        for(int[] curr : intervals) {
            // prev end is larger than curr start means that prev and curr intersect
            // merge the 2 intervals by taking the max of boths end replacing prev end
            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            }
            // if no intersect, assign curr to prev and add to ans list 
            else {
                prev = curr;
                ans.add(prev);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
