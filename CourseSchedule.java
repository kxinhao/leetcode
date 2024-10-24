/**
 * LeetCode 207 Course Schedule (Medium)
 * Ensure no cycle so that the course list selection is completable (Directed Acyclic Graph)
 * BFS (best ans found so far) Topological sorting via Kahn's algorithm (partial, possibility check)
 * count edges (representing prereqs) and subtract for each no-prereq course
 * and derivative course found, if 0 at the end, means schedule is possible
 */

// 9th impl
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] inCourse = new List[numCourses];//array of courses list with ind as prereq
        Queue<Integer> queue = new LinkedList<Integer>();// stores courses with no prereq
        int[] incomingEdges = new int[numCourses];// no of prereq courses for ind courses 
        int edgeCnt = prerequisites.length;

        for(int i=0; i<inCourse.length; i++) {
            inCourse[i] = new LinkedList<Integer>();
        }
        // store prereq count for each course (pre[0]) in incomingEdges array
        // add course (pre[0]) to list of courses which have (pre[1]) as prereq
        for(int[] pre : prerequisites) {
            incomingEdges[pre[0]]++;
            inCourse[pre[1]].add(pre[0]);
        }
        // add course to queue if no prerequisites (Kahn's algo)
        for(int i = 0; i<incomingEdges.length;i++) {
            if(incomingEdges[i]==0) queue.offer(i);
        }

        // partial Kahn's algorithm (without sorted list of nodes)
        while(!queue.isEmpty()) {
            // remove course from queue which has no prereq 
            int curr = queue.poll();
            // for each course that has prereq of curr course
            for(int in : inCourse[curr]) {
                // -1 for each edge seen
                edgeCnt--;
                // if course being checked has no further prereq, add to queue to replace prev
                if(--incomingEdges[in]==0) queue.offer(in);
            }
        }
        // if edgeCnt is 0, means no further prereq needed for courses thus possible to complete
        return edgeCnt==0;
    }
}
