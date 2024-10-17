/**
 * LeetCode 133 Clone Graph (Medium)
 * TC: O(N+E), SC: O(N+E) Node + Edges
 */

// 2nd impl
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    private Node dfs(Node node, HashMap<Integer,Node> map) {
        if(node == null) return null;
        // return node if seen, else add to visited map and explore neighbors
        if(map.containsKey(node.val)) return map.get(node.val);
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        for(Node nn : node.neighbors) newNode.neighbors.add(dfs(nn, map));
        return newNode;
    }
}
