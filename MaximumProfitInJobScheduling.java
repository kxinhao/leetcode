/**
 * LeetCode 1235 Maximum Profit in Job Scheduling (Hard)
 * Sort by endTime(O(NlogN) + Dynamic Programing + Binary Search (O(logN))
 * Idea is to sort by endtime, then binary search prev jobs to find possible prev jobs and
 * get the best profit at each job timeslot
 * 1. sort by endTime(O(NLogN)) to prevent jobs with earlier end times from being left out
 * 2. binary search the jobs between first and prev job to get the latet possible job
 * 3. store the largest possible profit at each job within dp[]
 * TC: O(N * logN)
 * SC: O(N)
 */
// 4th impl

class Solution {
    class Job {
        int start, end, profit;           
        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    // O(NlogN) + O(N)*O(logN) (N is size of jobs array, Binary search for each member of array)
    // O(2NlogN) = O(NlogN) simplified
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = profit.length;
            
        Job[] jobs = new Job[len];
        for (int i = 0; i < len; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        // sort by end time to prevent overlapping calculations
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        
        // Dynamic Programming to find best possible profit at last element of dp array
        int[] dp = new int[len];
        dp[0] = jobs[0].profit;
        
        for (int i = 1; i < len; i++) {
            int start = jobs[i].start, left = 0, right = i - 1, res = -1;
            
            while (left <= right) {
                int mid = left + ((right - left) >> 1); // >>1 == /2
                if (jobs[mid].end <= start) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            int currProfit = jobs[i].profit;
            // job that ends before this job starts exists, add the profit possible for it to curr job
            if (res != -1) currProfit += dp[res];
            int prevProfit = dp[i - 1];
            dp[i] = Math.max(currProfit, prevProfit);
        }
        return dp[len - 1];
    }
}
