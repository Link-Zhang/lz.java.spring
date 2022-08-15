package cn.sh.lz.cig.c2p10;

import cn.sh.lz.cig.c2c.LinkedNode;
import cn.sh.lz.cig.c2c.Node;

/**
 * Created by Link at 16:33 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] l1 = new int[]{9, 3, 7};
        int[] l2 = new int[]{6, 3};
        Node node = new Node();
        LinkedNode head1 = node.build(l1);
        LinkedNode head2 = node.build(l2);
        Number number = new Number();
        LinkedNode result1 = number.add(head1, head2);
        LinkedNode result2 = number.minus(head1, head2);
        node.print(head1);
        node.print(head2);
        node.print(result1);
        node.print(result2);
    }
}
