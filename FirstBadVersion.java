/**
 * LeetCode 278 First Bad Version (Easy)
 * Rmb to prevent overflows and infinite loops
 */

// 2nd impl, binary search variant
// track left bound of left/right bound(ind), no need to find and return m value
// using isBadVersion(m-1)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        do {
            // mid is found by lo + (hi-lo)/2 to prevent overflow when lo and hi are at max int val
            int m = (int) Math.floor(lo + (hi-lo)/2);
            // if m version is part of bad versions, pull down hi to m as further versions r bad
            // if m is not part of bad vers, move lo up to m+1 to check upper half
            // do until lo >= hi after last +1 so that lo is first occurance of bad ver
            if(isBadVersion(m)) {
              hi = m;
            } else {
              lo = m+1;
            }
        } while(lo<hi);
      return lo;
    }
}
