/**
 * LeetCode 207 Course Schedule (Medium)
 * Ensure no cycle so that the course list selection is completable
 * BFS (best ans found so far)
 * count edges (representing prereq courses) and subtract for each no-prereq course
 * and derivative course found, if 0 at the end, means schedule is possible
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] goCourses = new List[numCourses]; // array to store list of prereq courses
        Queue<Integer> queue = new LinkedList<Integer>(); // stores courses with no prereq
        int[] incomingEdges = new int[numCourses]; // courses to be taken 
        for(int i=0; i<goCourses.length; i++) {
            goCourses[i] = new LinkedList<Integer>();
        }
        // store prereq count for each course (pre[0]) in incomingEdges array
        // add course (pre[0]) to list of courses which have (pre[1]) as prereq
        for(int[] pre : prerequisites) {
            incomingEdges[pre[0]]++;
            goCourses[pre[1]].add(pre[0]);
        }
        // add course to queue if no prerequisites
        for(int i = 0; i<incomingEdges.length;i++) {
            if(incomingEdges[i]==0) queue.add(i);
        }
        // count down from edges to check for cycle
        // go through courses in queue to check if their linked courses result in completion
        int edgeCnt = prerequisites.length;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int go : goCourses[curr]) {
                edgeCnt--;
                // if course being checked has no further prereq, add to queue to replace prev
                if(--incomingEdges[go]==0) queue.offer(go);
            }
        }
        // if edgeCnt is 0, means no further prereq needed for courses thus possible to complete
        return edgeCnt==0;
    }
}
