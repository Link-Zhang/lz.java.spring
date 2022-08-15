package cn.sh.lz.cig.c2p6;

import cn.sh.lz.cig.c2c.LinkedNode;
import cn.sh.lz.cig.c2c.Node;

/**
 * Created by Link at 15:11 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] l1 = new int[41];
        for (int i = 0; i < 41; i++) {
            l1[i] = i + 1;
        }
        Node node = new Node();
        LinkedNode head = node.build(l1);
        LinkedNode cur = head;
        while (null != cur.getNext()) {
            cur = cur.getNext();
        }
        cur.setNext(head);
        LinkedNode tail = cur;
        System.out.println("The Josephus Loop:");
        node.print(head, tail);

        Josephus josephus = new Josephus();
        head = josephus.schemingJosephus(head, 2);
        System.out.println("The Lucky Dog:");
        node.print(head, head);

        System.out.println(josephus.getLuckyDogNumber(41, 2));
    }
}
