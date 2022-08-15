package cn.sh.lz.cig.c2c;

import java.util.LinkedList;
import java.util.Optional;

/**
 * Created by Link at 11:57 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class Node {
    public LinkedNode build(int[] array) {
        if (null == array) {
            return null;
        }
        LinkedNode head = new LinkedNode(array[0]);
        LinkedNode temp = head;
        for (int i = 1; i < array.length; i++) {
            LinkedNode newNode = new LinkedNode(array[i]);
            temp.setNext(newNode);
            temp = temp.getNext();
        }
        return head;
    }

    public DoubleLinkedNode buildDouble(int[] array) {
        if (null == array) {
            return null;
        }
        DoubleLinkedNode head = new DoubleLinkedNode(array[0]);
        head.setLast(null);
        head.setNext(null);
        DoubleLinkedNode temp = head;
        for (int i = 1; i < array.length; i++) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(array[i]);
            newNode.setLast(temp);
            temp.setNext(newNode);
            temp = newNode;
        }
        temp.setNext(null);
        return head;
    }

    public RandomLinkedNode buildRandom(int[] array) {
        if (null == array) {
            return null;
        }
        RandomLinkedNode head = new RandomLinkedNode(array[0]);
        RandomLinkedNode cur = head;
        LinkedList<RandomLinkedNode> list = new LinkedList<>();
        list.offer(cur);
        for (int i = 1; i < array.length; i++) {
            RandomLinkedNode newNode = new RandomLinkedNode(array[i]);
            cur.setNext(newNode);
            list.offer(newNode);
            cur = cur.getNext();
        }
        cur = head;
        for (int i = 0; i < array.length; i++) {
            int rand = (int) (Math.random() * (array.length + 1));
            if (array.length == rand) {
                list.get(i).setRand(null);
            } else {
                list.get(i).setRand(list.get(rand));
            }
        }
        return head;
    }

    public LinkedNode reverse(LinkedNode head) {
        LinkedNode pre = null;
        LinkedNode next;
        while (null != head) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    public DoubleLinkedNode reverse(DoubleLinkedNode head) {
        DoubleLinkedNode pre = null;
        DoubleLinkedNode next;
        while (null != head) {
            next = head.getNext();
            head.setNext(pre);
            head.setLast(next);
            pre = head;
            head = next;
        }
        return pre;
    }

    //    [head, ... , fPre, from, ... , to, tPos, ... , tail]
    public LinkedNode reversePart(LinkedNode head, int from, int to) {
        int len = 0;
        LinkedNode cur = head;
        LinkedNode fPre = null;
        LinkedNode tPos = null;
        while (null != cur) {
            len++;
            fPre = len == from - 1 ? cur : fPre;
            tPos = len == to + 1 ? cur : tPos;
            cur = cur.getNext();
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        // [ fPre, node1, node2, next, ... , tPos]
        LinkedNode node1 = null == fPre ? head : fPre.getNext();
        LinkedNode node2 = node1.getNext();
        node1.setNext(tPos);
        LinkedNode next;
        while (tPos != node2) {
            next = node2.getNext();
            node2.setNext(node1);
            node1 = node2;
            node2 = next;

        }
        if (null != fPre) {
            fPre.setNext(node1);
            return head;
        }
        return node1;
    }

    public DoubleLinkedNode reversePart(DoubleLinkedNode head, int from, int to) {
        int len = 0;
        DoubleLinkedNode cur = head;
        DoubleLinkedNode fPre = null;
        DoubleLinkedNode tPos = null;
        while (null != cur) {
            len++;
            tPos = len == to + 1 ? cur : tPos;
            fPre = len == from - 1 ? cur : fPre;
            cur = cur.getNext();
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        DoubleLinkedNode node1 = fPre == null ? head : fPre.getNext();
        DoubleLinkedNode node2 = node1.getNext();
        if (null != tPos) {
            tPos.setLast(node1);
        }
        node1.setNext(tPos);
        node1.setLast(node2);
        DoubleLinkedNode next;
        while (tPos != node2) {
            next = node2.getNext();
            node2.setNext(node1);
            node2.setLast(next);
            node1 = node2;
            node2 = next;
        }
        if (null != fPre) {
            fPre.setNext(node1);
            node1.setLast(fPre);
            return head;
        }
        node1.setLast(null);
        return node1;
    }

    public void print(LinkedNode head) {
        while (null != head) {
            System.out.print(head.getData() + " => ");
            head = head.getNext();
        }
        System.out.println("null");
    }

    public void print(LinkedNode head, LinkedNode tail) {
        while (null != head && tail != head) {
            System.out.print(head.getData() + " => ");
            head = head.getNext();
        }
        if (null != head) {
            System.out.print(head.getData() + " => ");
        }
        System.out.println("loop");
    }

    public void print(DoubleLinkedNode head) {
        while (null != head) {
            System.out.print(head.getLast() + " <= ");
            System.out.print(head + " : " + head.getData());
            System.out.println(" => " + head.getNext());
            head = head.getNext();
        }
    }

    public void print(RandomLinkedNode head) {
        int i = 0;
        RandomLinkedNode cur = head;
        while (null != cur) {
            System.out.println("Optional[" + ++i + "]:data=" + cur.getData());
            System.out.println("next->" + Optional.ofNullable(cur.getNext()).map(RandomLinkedNode::getData).orElse(null));
            System.out.println("rand->" + Optional.ofNullable(cur.getRand()).map(RandomLinkedNode::getData).orElse(null));
            System.out.println();
            cur = cur.getNext();
        }
    }

    public LinkedNode removeTheLastKthNode(LinkedNode head, int k) {
        if (null == head || k < 1) {
            return head;
        }
        LinkedNode ahead = head;
        LinkedNode pre = null;
        LinkedNode cur = head;
        while (0 < k && null != ahead) {
            k--;
            ahead = ahead.getNext();
        }
        if (k > 0) {
            return head;
        }
        while (null != ahead) {
            ahead = ahead.getNext();
            pre = cur;
            cur = cur.getNext();
        }
        if (null == pre) {
            return cur.getNext();
        }
        if (null != cur) {
            pre.setNext(cur.getNext());
        }
        return head;
    }

    public DoubleLinkedNode removeTheLastKthNode(DoubleLinkedNode head, int k) {
        if (null == head | k < 1) {
            return head;
        }
        DoubleLinkedNode ahead = head;
        DoubleLinkedNode pre = null;
        DoubleLinkedNode cur = head;
        while (k > 0 && null != ahead) {
            k--;
            ahead = ahead.getNext();
        }
        if (k > 0) {
            return head;
        }
        while (null != ahead) {
            ahead = ahead.getNext();
            pre = cur;
            cur = cur.getNext();
        }
        if (null == pre) {
            cur.getNext().setLast(null);
            return cur.getNext();
        }
        if (null != cur) {
            if (null != cur.getNext()) {
                cur.getNext().setLast(pre);
                pre.setNext(cur.getNext());
            } else {
                pre.setNext(null);
            }
        }
        return head;
    }

    public LinkedNode removeTheMiddleNode(LinkedNode head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        if (null == head.getNext().getNext()) {
            return head.getNext();
        }
        LinkedNode cur = head;
        LinkedNode doubleCur = head.getNext().getNext();
        while (null != doubleCur.getNext() && null != doubleCur.getNext().getNext()) {
            cur = cur.getNext();
            doubleCur = doubleCur.getNext().getNext();
        }
        cur.setNext(cur.getNext().getNext());
        return head;
    }

    public DoubleLinkedNode removeTheMiddleNode(DoubleLinkedNode head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        if (null == head.getNext().getNext()) {
            return head.getNext();
        }
        DoubleLinkedNode cur = head;
        DoubleLinkedNode doubleCur = head.getNext().getNext();
        while (null != doubleCur.getNext() && null != doubleCur.getNext().getNext()) {
            cur = cur.getNext();
            doubleCur = doubleCur.getNext().getNext();
        }
        cur.getNext().getNext().setLast(cur);
        cur.setNext(cur.getNext().getNext());
        return head;
    }

    public LinkedNode removeByRatio(LinkedNode head, int numerator, int denominator) {
        if (numerator < 1 || numerator > denominator) {
            return head;
        }
        int n = 0;
        LinkedNode cur = head;
        while (null != cur) {
            n++;
            cur = cur.getNext();
        }
        n = (int) Math.ceil((double) (numerator * n) / (double) denominator);
        if (1 == n) {
            head = head.getNext();
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.getNext();
            }
            cur.setNext(cur.getNext().getNext());
        }
        return head;
    }

    public DoubleLinkedNode removeByRatio(DoubleLinkedNode head, int numerator, int denominator) {
        if (numerator < 1 || numerator > denominator) {
            return head;
        }
        int n = 0;
        DoubleLinkedNode cur = head;
        while (null != cur) {
            n++;
            cur = cur.getNext();
        }
        n = (int) Math.ceil((double) (numerator * n) / (double) denominator);
        if (1 == n) {
            head = head.getNext();
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.getNext();
            }
            cur.getNext().getNext().setLast(cur);
            cur.setNext(cur.getNext().getNext());
        }
        return head;
    }

    // 时间复杂度O(n),空间复杂度O(1)
    public boolean isPalindrome(LinkedNode head) {
        if (null == head || null == head.getNext()) {
            return true;
        }
        LinkedNode leftNode = head;
        LinkedNode middleLeftNode = head;
        LinkedNode rightNode = head;
        while (null != rightNode.getNext() && null != rightNode.getNext().getNext()) {
            middleLeftNode = middleLeftNode.getNext();
            rightNode = rightNode.getNext().getNext();
        }
        LinkedNode middleRightNode = middleLeftNode.getNext();
        middleLeftNode.setNext(null);
        Node node = new Node();
        LinkedNode reversedRightHead = node.reverse(middleRightNode);
        boolean result = true;
        while (null != leftNode && null != rightNode) {
            if (leftNode.getData() != rightNode.getData()) {
                result = false;
                break;
            }
            leftNode = leftNode.getNext();
            rightNode = rightNode.getNext();
        }
        middleRightNode = node.reverse(reversedRightHead);
        middleLeftNode.setNext(middleRightNode);
        return result;
    }

    public LinkedNode getLoopNode(LinkedNode head) {
        if (null == head || null == head.getNext() || null == head.getNext().getNext()) {
            return null;
        }
        LinkedNode slow = head.getNext();
        LinkedNode fast = head.getNext().getNext();
        while (slow != fast) {
            if (null == fast.getNext() || null == fast.getNext().getNext()) {
                return null;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        fast = head;
        while (slow != fast) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    public LinkedNode getIntersectNode(LinkedNode head1, LinkedNode head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        LinkedNode loop1 = getLoopNode(head1);
        LinkedNode loop2 = getLoopNode(head2);
        if (null == loop1 && null == loop2) {
            return getIntersectNodeWithoutLoop(head1, head2);
        }
        if (null != loop1 && null != loop2) {
            return getIntersectNodeWithLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    private LinkedNode getIntersectNodeWithLoop(LinkedNode head1, LinkedNode loop1, LinkedNode head2, LinkedNode loop2) {
        LinkedNode cur1 = null;
        LinkedNode cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.getNext();
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.getNext();
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.getNext();
            }
            while (cur1 != cur2) {
                cur1 = cur1.getNext();
                cur2 = cur2.getNext();
            }
            return cur1;
        } else {
            cur1 = loop1.getNext();
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.getNext();
            }
            return null;
        }
    }

    private LinkedNode getIntersectNodeWithoutLoop(LinkedNode head1, LinkedNode head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        LinkedNode cur1 = head1;
        LinkedNode cur2 = head2;
        int n = 0;
        while (null != cur1.getNext()) {
            n++;
            cur1 = cur1.getNext();
        }
        while (null != cur2.getNext()) {
            n--;
            cur2 = cur2.getNext();
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.getNext();
        }
        while (cur1 != cur2) {
            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
        }
        return cur1;
    }

    public LinkedNode getDataNode(LinkedNode head, int n) {
        LinkedNode cur = head;
        while (null != cur) {
            if (n == cur.getData()) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    public LinkedNode reverseEveryKNode(LinkedNode head, int k) {
        if (k < 2) {
            return head;
        }
        LinkedNode pre = null;
        LinkedNode cur = head;
        LinkedNode next = null;
        LinkedNode start = null;
        int count = 1;
        while (cur != null) {
            next = cur.getNext();
            if (count == k) {
                start = null == pre ? head : pre.getNext();
                head = null == pre ? cur : head;
                doReverseKNode(pre, start, cur, next);
                // pre的值要改成start，而不是cur
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public void doReverseKNode(LinkedNode left, LinkedNode start, LinkedNode end, LinkedNode right) {
        LinkedNode pre = start;
        LinkedNode cur = start.getNext();
        LinkedNode next = null;
        while (cur != right) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.setNext(end);
        }
        start.setNext(right);
    }
}
