package cn.sh.lz.cig.c2p7;

import cn.sh.lz.cig.c2c.LinkedNode;
import cn.sh.lz.cig.c2c.Node;

/**
 * Created by Link at 16:19 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 3, 2, 1};
        Node node = new Node();
        LinkedNode head = node.build(l1);
        node.print(head);
        System.out.println(node.isPalindrome(head));
    }
}
