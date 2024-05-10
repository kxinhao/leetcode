/**
 * LeetCode 133 Clone Graph (Medium)
 *
 */

class Solution {
    public Node cloneGraph(Node node) {
        public HashMap<Integer, Node> map = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node==null) return null;
            if(map.contains(node.val)) return map.get(node.val);
            Node newNode = new Node(node.val, new ArrayList<Node>());
            map.put(node.val, newNode);
            for(Node nn : node.neighbors) newNode.neighbors.add(cloneGraph(nn));
            return newNode;
        }
    }
}
