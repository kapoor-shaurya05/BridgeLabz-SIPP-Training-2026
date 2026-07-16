public class DeleteBST {

    public static Node delete(Node root, int key) {

        if (root == null) {
            return null;
        }
        if (key < root.val) {

            root.left = delete(root.left, key);

        }
        else if (key > root.val) {

            root.right = delete(root.right, key);

        }
        else {

            // Case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3
            Node successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }
        return root;
    }

    private static Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}