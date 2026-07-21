class DeletionPostorderTraversal{

    public void deleteFolderTree(TreeNode root){

        if (root == null) return;

        deleteFolderTree(root.left);
        deleteFolderTree(root.right);
        deleteNode(root);
    }

    private void deleteNode(TreeNode node){

        System.out.println("Deleted : " + node.val);

        // Actual deletion logic can be written here.
    }
}