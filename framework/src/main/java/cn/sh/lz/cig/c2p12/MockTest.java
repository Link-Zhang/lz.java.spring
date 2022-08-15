package cn.sh.lz.cig.c2p12;

import cn.sh.lz.cig.c2c.LinkedNode;
import cn.sh.lz.cig.c2c.Node;

/**
 * Created by Link at 14:36 on 2022/08/12.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] l = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Node node = new Node();
        LinkedNode head = node.build(l);
        node.print(head);
        head = node.reverseEveryKNode(head, 3);
        node.print(head);

        head = node.build(l);
        int k = 3;
        for (int i = 0; i < l.length / k; i++) {
            head = node.reversePart(head, i * k + 1, (i + 1) * k);
        }
//        head = node.reversePart(head, l.length / k, l.length);
        node.print(head);
    }
}
