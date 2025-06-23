// Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

// serialize() : stores the tree into an array a and returns the array.
// deSerialize() : deserializes the array to the tree and returns the root of the tree.
// Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).



class Tree {
    
    // Serialize function
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                result.add(-1); // use -1 for NULL
            } else {
                result.add(current.data);
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return result;
    }

    // Deserialize function
    public Node deSerialize(ArrayList<Integer> arr) {
        if (arr.size() == 0 || arr.get(0) == -1) return null;

        Node root = new Node(arr.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.size()) {
            Node current = queue.poll();

            // Left child
            if (arr.get(i) != -1) {
                current.left = new Node(arr.get(i));
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.size() && arr.get(i) != -1) {
                current.right = new Node(arr.get(i));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}
