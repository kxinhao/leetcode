/**
 * LeetCode 84 Largest Rectangle in Histogram (Hard)
 * Naive soln is O(N^2), loop through array for each element to find next or prev smaller block
 * use monotonic stack to track for O(N) soln
 * **Note** increasing/decreasing monotonic stack refers to order of stack from bottom up
 *          - increasing monotonic stack finds next/prev smaller value
 *          - decreasing monotonic stack finds next/prev larger value
 */

// strictly increasing monotonic stack soln TC: O(N) 63ms, SC: O(N) 57.8MB
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? -1 : heights[i];
            // strictly increasing as equal values are popped
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            } 
            stack.push(i);
        }
        return ans;
    }
}

// stack soln TC: O(N) 69ms, SC: O(N) 57.2MB
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len;) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }
}

// non-stack soln TC: O(N) 8ms, SC: O(N) 57.6MB
// double pointer method, use i to find p with i representing traversal of input array
// and p representing traversal of stack
// calcs max area for each height[] elem possible
// eg. [2,1,5,6,2,3]
class Solution {
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left < current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right < current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            // p points to prev in height[] ref
            int p = i - 1;
            // while p ind is in valid ind range and height at p >= height at i, find prev smaller
            while (p >= 0 && height[p] >= height[i]) {
                // p var replacement with p index element in lessFromLeft finds prev smaller 
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        // lessFromLeft[-1,-1,1,2,1,4]

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        // lessFromRight[1,6,4,4,6,6]

        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        // maxArea[2,6,10,6,8,3] = 10
        //
        return maxArea;
    }
}
