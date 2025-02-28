/**
 * LeetCode 84 Largest Rectangle in Histogram (Hard)
 * Naive soln is O(N^2), loop through array for each element to find next or prev smaller block
 * use monotonic stack to track for O(N) soln
 * **Note** increasing/decreasing monotonic stack refers to order of stack from bottom up
 *          - increasing monotonic stack is from small to large
 *              + next smaller assigns val in while loop, while stackTop > curr
 *              + prev smaller assigns val outside while loop, while stackTop >= curr
 *          - decreasing monotonic stack is from large to small
 *              + next greater assigns val in while loop, while stackTop < curr
 *              + prev greater assings val outside while loop, while stackTop <= curr
 */

// monotonic stack ans, single pass calc of nextSmaller and prevSmaller values
// TC: O(N) 57ms(79%), SC: O(N) 56.12MB(96%)
// 2nd impl
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] nextSmaller = new int[heights.length];
        int[] prevSmaller = new int[heights.length];
        Arrays.fill(nextSmaller, heights.length); // right sided wall 
        Arrays.fill(prevSmaller, -1); // left sided wall
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<heights.length; i++) {
            // pop each element in stack larger than current element (excluding equals)
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]) {
                int stackTop = stack.pop();
                // nextSmaller will be strictly smaller than current element
                nextSmaller[stackTop] = i;
            }
            if(!stack.isEmpty()) prevSmaller[i] = stack.peek();
            stack.push(i);
        }

        for(int i = 0; i<heights.length; i++) {
            int currHeight = heights[i]; // max height for current rectangle
            int width = nextSmaller[i] - prevSmaller[i] -1; // -1 to subtract other side of bounds
            maxArea = Math.max(maxArea, currHeight*width);
        }
        return maxArea;
    }
}

// find next smaller block, use strictly increasing monotonic stack
// strictly increasing monotonic stack soln TC: O(N) 63ms, SC: O(N) 57.8MB
// [2,1,5,6,2,3]
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int largestArea = 0;
        // goes to = heights.length as first iteration is pushing of first index to stack, 
        // actual operation happens on next iteration
        for (int i = 0; i <= heights.length; i++) {
            // index at heights.length bounded by -1 value
            int curr = (i == heights.length) ? -1 : heights[i];
            // popping condition
            // strictly increasing as >= values are popped
            while (!stack.isEmpty() && heights[stack.peek()] >= curr) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                largestArea = Math.max(largestArea, h * w);
            } 
            stack.push(i);
        }
        return largestArea;
    }
}

// shortened array as stack soln TC: O(N) 7ms
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        int[] stack = new int[n + 1];
        int ind = -1;
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : h[i];
            while (ind != -1 && height < heights[stack[ind]]) {
                int hh = heights[stack[ind--]];
                int width = (ind== -1) ? i : i - 1 - stack[ind];
                max = Math.max(max, hh * width);
            }
            stack[++ind] = i;
        }
        return max;
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
