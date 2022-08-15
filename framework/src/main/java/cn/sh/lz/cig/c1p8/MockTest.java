package cn.sh.lz.cig.c1p8;

/**
 * Created by Link at 16:54 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] array = new int[]{3, 4, 5, 1, 2};
        TreeNode root;
        root = tree.buildMaxTree(array);
        tree.print(root);

        root = tree.buildMinTree(array);
        tree.print(root);

        tree.preOrder(root);
        System.out.println();

        tree.inOrder(root);
        System.out.println();

        tree.postOrder(root);
        System.out.println();

        tree.levelOrder(root);
        System.out.println();

        System.out.println(tree.getDepth(root));
        System.out.println(tree.getWidth(root));

        System.out.println(tree.getNodeCount(root));
        System.out.println(tree.getLeafNodeCount(root));
    }
}
