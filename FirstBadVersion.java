// binary search variant
// trick is to track left bound of left/right bound, no need to find and return m value
// using isBadVersion(m-1)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        do {
            int m = (int) Math.floor(lo + (hi-lo)/2);
            if(isBadVersion(m)) {
              hi = m;
            } else {
              lo = m+1;
            }
        } while(lo<hi);
      return lo;
    }
}
