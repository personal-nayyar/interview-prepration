package companies.oracle;

import code.problems.tree.TreeNode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

import static code.problems.tree.BinaryTree.*;

public class LevelOrderBSTcheck {

    public static void main(String[] args) {
        Integer[] arr =  {8,5,11,null,null,10,12,7,null};
        TreeNode root = generateBinaryTree(arr);
        printNode(root);
        System.out.println(isBST(root));

        arr = new Integer[]{8,5,13,null,null,10,16,9,11};
        root = generateBinaryTree(arr);
        printNode(root);
        System.out.println(isBST(root));
    }

    static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTUtil(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return isBSTUtil(root.left, min, root.val - 1)
                && isBSTUtil(root.right, root.val + 1, max);
    }

    static TreeNode generateBinaryTree(Integer[] levelOrder){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrder[0]);
        queue.add(root);
        int i = 1;
        while(i < levelOrder.length){
            TreeNode node = queue.poll();
            if(levelOrder[i] != null){
                node.left = new TreeNode(levelOrder[i]);
                queue.add(node.left);
            }
            i++;
            if(i >= levelOrder.length){
                break;
            }
            if(levelOrder[i] != null){
                node.right = new TreeNode(levelOrder[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
