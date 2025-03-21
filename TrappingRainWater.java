/**
 * LeetCode 42 Trapping Rain Water (Hard)
 * TC: O(N), SC: O(1)
 * single pass soln, 2 pointer l and r moving inward, calc vol at each point
 * Monotonic stack soln (TC: O(N), SC: O(N))
 */
// 4th impl, rmb to use right/left as ind for height array for comparison with
// height val/maxLeft/maxRight

class Solution {
    public int trap(int[] height) {
        if(height==null || height.length<2) return 0;
        int left = 0, right = height.length-1, maxLeft = 0, maxRight = 0, waterVol = 0;
        while(left<right) {
            if(height[left]<height[right]) {
                if(height[left]>=maxLeft) maxLeft = height[left];
                else {
                    waterVol += maxLeft - height[left];
                }
                left++;
            } else {
                if(height[right]>=maxRight) maxRight = height[right];
                else {
                    waterVol += maxRight - height[right];
                }
                right--;
            }
        }
        return waterVol;
    }
}

// Monotonic stack soln
// 3rd impl
class Solution {
    public int trap(int[] height) {
        int totalVol = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<height.length; i++) {
            // monotonic strictly decreasing stack
            // enter while right wall (height[i]) is <= top stack value,
            // meaning a volume may be found if left wall exists
            while(!stack.isEmpty() && height[stack.peek()]<=height[i]) {
                int stacktop = stack.pop();
                // only calc volme when elements remain in stack to represent left wall
                if(!stack.isEmpty()) {
                    // height of current possible block of water calculated using lower of l/r wall 
                    // and subtracting height of the bottom (popped stacktop)
                    int h = Math.min(height[stack.peek()], height[i]) - height[stacktop];
                    // +1 to calc volme bounded by walls, can be i-stack.peek()-1 as well
                    int w = i - (stack.peek()+1);
                    totalVol += h*w;
                }
            }
            stack.push(i);
        }
        return totalVol;
    }
}
