package code.problems.tree;

import com.sun.source.tree.Tree;

public class LCA {
    static TreeNode lcaBTree(TreeNode root, int n1, int n2){
        if (root == null)
            return null;
        if (root.val == n1 || root.val == n2)
            return root;
        TreeNode left = lcaBTree(root.left, n1, n2);
        TreeNode right = lcaBTree(root.right, n1, n2);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    static TreeNode lcaBST(TreeNode root, int n1, int n2){
        if (root == null)
            return null;
        if (n1 < root.val  && n2 < root.val)
            return lcaBST(root.left, n1, n2);
        if (n1 > root.val && n2 > root.val)
            return lcaBST(root.right, n1, n2);
        return root;
    }
}
