/**
 * LeetCode 57 Insert Interval (Medium)
 * brute force impl, failed at non overlap new interval test
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null||intervals.length==0) return new int[][] {newInterval};
        int newLo = newInterval[0], newHi = newInterval[1];
        int intervalCount = 0, overlapStart=0, overlapEnd=0;
        boolean intervalIntersect = false;
        for(int i = 0; i<intervals.length; i++) {
            int lo = intervals[i][0], hi = intervals[i][1];
            intervalCount++;
            if((newLo>=lo&&newLo<=hi)||(newHi>=lo&&newHi<=hi)||(newLo<lo&&newHi>hi)){
                intervalCount--; 
                intervalIntersect = true;
            } else {
                intervalIntersect = false;
            }
            if(intervalIntersect) {
                if(lo<newLo) {
                    newLo = lo;
                    overlapStart = i;
                    overlapEnd = i;
                }
                if(hi>newHi) { 
                    newHi = hi;
                    overlapEnd = i;
                }
            }
        }
        intervalCount++;
        int[][] ans = new int[intervalCount][2];
        int shift = overlapEnd - overlapStart;
        for(int i = 0; i<intervals.length;i++) {
            if(i==overlapStart) {
                ans[i] = new int[] {newLo,newHi};
                i = overlapEnd;
            } else if(i>overlapStart){
                ans[i-shift] = intervals[i];
            } else {
                ans[i] = intervals[i];
            }
        }
        return ans;
    }
}
