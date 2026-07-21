class BinaryTreeHeight{

    public int height(TreeNode node){

        if (node == null) return -1;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isTooDeep(TreeNode root, int threshold) {
        return height(root) > threshold;
    }
}