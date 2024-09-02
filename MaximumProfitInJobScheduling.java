/**
 * LeetCode 1235 Maximum Profit in Job Scheduling (Hard)
 * Sort by endTime + Dynamic Programing + Binary Search
 * DP array stores best profit for each job under consideration after sorting by end time
 * Binary search discovers non overlapping job with previously considered jobs
 * TC: O(N * logN)
 * SC: O(N)
 */

class Solution {
    class Job {
        int start;
        int end;
        int profit;
            
        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = profit.length;
            
        Job[] jobs = new Job[len];
        for (int i = 0; i < len; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        
        // Dynamic Programming to find best possible profit at last element of dp array
        int[] dp = new int[len];
        dp[0] = jobs[0].profit;
        
        for (int i = 1; i < len; i++) {
            int start = jobs[i].start;
            int left = 0;
            int right = i - 1;
            int res = -1;
            
            // Binary Search to find if no overlap on current job with mid job
            while (left <= right) {
                int mid = left + ((right - left) >> 1); // >>1 == /2
                if (jobs[mid].end <= start) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            int take = jobs[i].profit;
            // summation of profit with discovered overlapping job
            if (res != -1) {
                take += dp[res];
            }
            
            int nottake = dp[i - 1];
            
            dp[i] = Math.max(take, nottake);
        }
        
        // return last element of dp array
        return dp[len - 1];
    }
}
