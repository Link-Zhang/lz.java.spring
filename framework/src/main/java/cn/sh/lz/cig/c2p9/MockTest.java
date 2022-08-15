package cn.sh.lz.cig.c2p9;

import cn.sh.lz.cig.c2c.Node;
import cn.sh.lz.cig.c2c.RandomLinkedNode;

/**
 * Created by Link at 16:28 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3};
        Node node = new Node();
        RandomLinkedNode head = node.buildRandom(list);
        node.print(head);
        System.out.println("-------------------------");
        Copy copy = new Copy();
        RandomLinkedNode result = copy.copy(head);
        node.print(result);
    }
}
