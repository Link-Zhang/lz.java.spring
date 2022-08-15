package cn.sh.lz.cig.c2p1;

import cn.sh.lz.cig.c2c.LinkedNode;
import cn.sh.lz.cig.c2c.Node;

/**
 * Created by Link at 14:01 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] l1 = new int[]{2, 4, 5, 6, 7, 8};
        int[] l2 = new int[]{1, 3, 4, 5, 6, 8, 9};
        Node node = new Node();
        LinkedNode head1 = node.build(l1);
        LinkedNode head2 = node.build(l2);
        node.print(head1);
        node.print(head2);
        new CommonPart().print(head1, head2);
        new CommonPart().print2(head1, head2);
    }
}
