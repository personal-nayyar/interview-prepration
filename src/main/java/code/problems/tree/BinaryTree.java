package code.problems.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {
    final TreeNode root;
    public BinaryTree(TreeNode root) {
        this.root = root;
    }
    public static void printNode(TreeNode root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);
                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }


    public static void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }


    public static void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }


    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printLevelOrder(root.left);
        printLevelOrder(root.right);
    }


    public static void printZigZag(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printZigZag(root.left);
        printZigZag(root.right);
    }


    public static void printVerticalOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printVerticalOrder(root.left);
        printVerticalOrder(root.right);
    }


    public static void printTopView(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTopView(root.left);
        printTopView(root.right);
    }


    public static void printBottomView(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printBottomView(root.left);
        printBottomView(root.right);
    }


    public static void printLeftView(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printLeftView(root.left);
        printLeftView(root.right);
    }


    public static void printRightView(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printRightView(root.left);
        printRightView(root.right);
    }
}

