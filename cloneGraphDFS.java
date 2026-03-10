// User function Template for Java

/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution {
    static HashMap<Node,Node> copies = new HashMap<>();
    Node cloneGraph(Node node) {
        if(node == null) return null;
        if(!copies.containsKey(node)){
            Node clone = new Node(node.val);
            copies.put(node,clone);
            for(Node neighbour : node.neighbors){
                clone.neighbors.add(cloneGraph(neighbour));
            }
        }
        return copies.get(node);
    }
}
