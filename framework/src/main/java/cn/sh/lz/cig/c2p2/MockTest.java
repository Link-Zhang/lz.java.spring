package cn.sh.lz.cig.c2p2;

import cn.sh.lz.cig.c2c.DoubleLinkedNode;
import cn.sh.lz.cig.c2c.LinkedNode;
import cn.sh.lz.cig.c2c.Node;

/**
 * Created by Link at 14:12 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] l1 = new int[]{3, 4, 5};
        Node node = new Node();
        LinkedNode head = node.build(l1);

        node.print(head);
        head = node.removeTheLastKthNode(head, 2);
        node.print(head);

        DoubleLinkedNode doubleHead = node.buildDouble(l1);
        node.print(doubleHead);
        System.out.println();
        doubleHead = node.removeTheLastKthNode(doubleHead, 2);
        node.print(doubleHead);
    }
}
