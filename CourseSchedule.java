/**
 * LeetCode 207 Course Schedule (Medium)
 * Ensure no cycle so that the course list selection is completable
 * BFS (best ans found so far)
 * count edges (representing prereqs) and subtract for each no-prereq course
 * and derivative course found, if 0 at the end, means schedule is possible
 * prereq [x,y] means to study x, y is prerequisite
 */
// 2nd impl
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] inCourse = new List[numCourses]; // courses that follow array ind course 
        Queue<Integer> queue = new LinkedList<Integer>(); // stores courses that can be taken
        int[] incomingEdges = new int[numCourses]; // no of prereq courses for ind course 
        int edgeCnt = prerequisites.length;

        for(int i=0; i<inCourse.length; i++) {
            inCourse[i] = new LinkedList<Integer>();
        }
        // store prereq count for each course (pre[0]) in incomingEdges array
        // add course (pre[0]) to list of courses which have (pre[1]) as prereq
        for(int[] pre : prerequisites) {
            incomingEdges[pre[0]]++;
            inCourse[pre[1]].add(pre[0]); // for course pre[1], there is a following pre[0] 
        }
        // add course to queue if no prerequisites
        for(int i = 0; i<incomingEdges.length;i++) {
            if(incomingEdges[i]==0) queue.add(i);
        }
        // count down from edges to check for cycle
        // parese courses in queue to check if their linked courses result in completion
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int in : inCourse[curr]) {
                edgeCnt--;
                // if course being checked has no further prereq, add to queue to replace prev
                if(--incomingEdges[in]==0) queue.offer(in);
            }
        }
        // if edgeCnt is 0, means no further prereq needed for courses thus possible to complete
        return edgeCnt==0;
    }
}
