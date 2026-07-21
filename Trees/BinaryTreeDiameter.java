class BinaryTreeDiameter{

    private int diameter = 0;
    public int longestCommunicationPath(TreeNode root){

        diameter = 0;
        height(root);

        return diameter;
    }

    private int height(TreeNode node){

        if (node == null) return -1;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}