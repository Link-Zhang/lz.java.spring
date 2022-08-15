package cn.sh.lz.cig.c2p6;

import cn.sh.lz.cig.c2c.LinkedNode;

/**
 * Created by Link at 15:12 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class Josephus {
    //  时间复杂度 O(n*m)
    public LinkedNode josephus(LinkedNode head, int m) {
        if (null == head || head.getNext() == head || m < 1) {
            return head;
        }
        LinkedNode last = head;
        while (last.getNext() != head) {
            last = last.getNext();
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.setNext(head.getNext());
                count = 0;
            } else {
                last = last.getNext();
            }
            head = last.getNext();
        }
        return head;
    }

    //  时间复杂度 O(n)
    public LinkedNode schemingJosephus(LinkedNode head, int m) {
        if (null == head || head.getNext() == head || m < 1) {
            return head;
        }
        LinkedNode cur = head.getNext();
        int count = 1;
        while (cur != head) {
            count++;
            cur = cur.getNext();
        }
        int number = getLuckyDogNumber(count, m);
        while (--number != 0) {
            head = head.getNext();
        }
        head.setNext(head);
        return head;
    }

    @Deprecated
    public int recursiveGetLuckyDogNumber(int i, int m) {
        if (1 == i) {
            return 1;
        }
        // old=(new+m-1)%i+1
        return (recursiveGetLuckyDogNumber(i - 1, m) + m - 1) % i + 1;
    }

    public int getLuckyDogNumber(int i, int m) {
        int result = 0;
        for (int j = 2; j <= i; ++j) {
            result = (result + m) % j;
        }
        return result + 1;
    }
}
