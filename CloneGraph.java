/**
 * LeetCode 133 Clone Graph (Medium)
 *
 */

class Solution {
    public Node cloneGraph(Node node) {
        // map acts as seen node tracker
        public HashMap<Integer, Node> map = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node==null) return null;
            // returns node if seen, else add to map and explore new node's neighbors
            if(map.contains(node.val)) return map.get(node.val);
            Node newNode = new Node(node.val, new ArrayList<Node>());
            map.put(node.val, newNode);
            // recursively call cloneGraph to add unseen nodes to neighbor list
            // clone neighbor nodes via existing node's neighbor list and 
            // add to new node neighbor list
            for(Node nn : node.neighbors) newNode.neighbors.add(cloneGraph(nn));
            return newNode;
        }
    }
}
