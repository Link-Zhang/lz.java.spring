package cn.sh.lz.cig.c2p11;

import cn.sh.lz.cig.c2c.LinkedNode;
import cn.sh.lz.cig.c2c.Node;

/**
 * Created by Link at 14:32 on 2022/08/10.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 3, 4, 5};
        Node node = new Node();
        LinkedNode head1 = node.build(l1);
        LinkedNode loop1 = node.getDataNode(head1, 3);
        LinkedNode tail1 = node.getDataNode(head1, 5);
        LinkedNode head2 = new LinkedNode(8);
        head2.setNext(loop1);
        tail1.setNext(loop1);
        node.print(head1, tail1);
        node.print(head2, tail1);
        LinkedNode intersectNode = node.getIntersectNode(head1, head2);
        node.print(intersectNode, intersectNode);
    }
}
