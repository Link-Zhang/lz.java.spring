package cn.sh.lz.cig.c2p1;

import cn.sh.lz.cig.c2c.LinkedNode;

/**
 * Created by Link at 14:03 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class CommonPart {
    public void print(LinkedNode head1, LinkedNode head2) {
        while (null != head1 && null != head2 && head1.getData() != head2.getData()) {
            if (head1.getData() < head2.getData()) {
                head1 = head1.getNext();
            } else if (head1.getData() > head2.getData()) {
                head2 = head2.getNext();
            }
        }
        while (null != head1 && null != head2 && head1.getData() == head2.getData()) {
            System.out.print(head1.getData() + " => ");
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        System.out.println("null");
    }

    public void print2(LinkedNode head1, LinkedNode head2) {
        while (null != head1 && null != head2) {
            if (head1.getData() < head2.getData()) {
                head1 = head1.getNext();
            } else if (head1.getData() > head2.getData()) {
                head2 = head2.getNext();
            } else {
                System.out.print(head1.getData() + " => ");
                head1 = head1.getNext();
                head2 = head2.getNext();
            }
        }
        System.out.println("null");
    }
}
