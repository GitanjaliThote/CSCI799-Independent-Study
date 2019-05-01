class TreeNode {

    TreeNode left =null;
    TreeNode right = null;
    int value;
    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class LowestCommonAncestorBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);

        TreeNode right = lowestCommonAncestor(root.right,p,q);

        return left == null? right:right == null? left:root;

    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode( 1);

        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        System.out.println("LCA(4, 6): " + lowestCommonAncestor(tree, tree.left.left , tree.right.left ).value);
    }




}