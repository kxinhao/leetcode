/**
 * LeetCode 1235 Maximum Profit in Job Scheduling (Hard)
 * Sort by endTime(O(NlogN) + Dynamic Programing + Binary Search (O(logN))
 * DP array stores best profit for each job under consideration after sorting by end time
 * Binary search discovers non overlapping job with previously considered jobs
 * TC: O(N * logN)
 * SC: O(N)
 * TODO: make comments more concise
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

    // O(NlogN) + O(N)*O(logN) (N is size of jobs array, Binary search for each member of array)
    // O(2NlogN) = O(NlogN) simplified
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
        
        // iteration through each job after jobs[0], decide to select the job or not
        // if job[i] does not overlap with a prior job, only its own profit will be considered,
        // else binary search will determine the last job that ends before this job starts and
        // the stored profit of possible prior jobs in dp[] will be summed with this job profit
        // The best profit possible will be compared between the selection of 
        // this job(and prior non overlapping ones) vs the best profit possible when the prev job
        // was under consideration
        for (int i = 1; i < len; i++) {
            int start = jobs[i].start;
            int left = 0, right = i - 1, res = -1;
            
            // Binary Search entire possible time period to find if no overlap with mid job
            while (left <= right) {
                int mid = left + ((right - left) >> 1); // >>1 == /2
                // not returning mid value when jobs[mid].end = start as we are trying to find
                // latest non overlapping job
                // if the binary searched job ends before this job starts, we can sum the best
                // profit tied to that job to this jobs profit. we store the ind for the best
                // we store best profit in res and continue binary search to find any jobs
                // which would end later but before this job starts
                if (jobs[mid].end <= start) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            int take = jobs[i].profit;
            // summation of profit with best possible profit of latest non overlapping jobs
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
