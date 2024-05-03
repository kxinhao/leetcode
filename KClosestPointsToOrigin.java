/**
 * LeetCode 973 K Closest Points to Origin (Medium)
 * Euclidean distance between target and origin is sqrt(x*x+y*y) where x and y are target point coords
 * implement euclidean comparator with b-a instead of a-b to get max heap from priorityqueue instead 
 * of default min heap
 */

class Solution {
  public int[][] kClosest(int[][] points, int k) {
    int[] distArr = new int[points.length];
    PriorityQueue<int[]>pq = new PriorityQueue<int[]>((a,b) -> b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]);
    for(int[] p : points) {
      pq.offer(p);
      if(pq.size()>k) pq.poll();
    }
    int[][]ans = new int[k][2];
    while(k>0) ans[--k] = pq.poll();
    return ans;
  }
}

