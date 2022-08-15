package cn.sh.lz.cig.c2p9;

import cn.sh.lz.cig.c2c.RandomLinkedNode;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by Link at 16:28 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class Copy {
    // 时间复杂度O(n),空间复杂度O(n)
    @Deprecated
    public RandomLinkedNode copy2(RandomLinkedNode head) {
        HashMap<RandomLinkedNode, RandomLinkedNode> map = new HashMap<>();
        RandomLinkedNode cur = head;
        while (null != cur) {
            map.put(cur, new RandomLinkedNode(cur.getData()));
            cur = cur.getNext();
        }
        cur = head;
        while (null != cur) {
            map.get(cur).setNext(map.get(cur.getNext()));
            map.get(cur).setRand(map.get(cur.getRand()));
            cur = cur.getNext();
        }
        return map.get(head);
    }

    // 时间复杂度O(n),空间复杂度O(1)
    public RandomLinkedNode copy(RandomLinkedNode head) {
        if (null == head)
            return null;
        // 1->(1)->2->(2)->3->(3)->null
        RandomLinkedNode cur = head;
        RandomLinkedNode next;
        while (null != cur) {
            next = cur.getNext();
            // cur->tempNewNode
            cur.setNext(new RandomLinkedNode(cur.getData()));
            // tempNewNode->next
            cur.getNext().setNext(next);
            cur = next;
        }
        // 复制rand
        cur = head;
        RandomLinkedNode curCopy;
        while (null != cur) {
            next = cur.getNext().getNext();
            curCopy = cur.getNext();
            curCopy.setRand(Optional.ofNullable(cur.getRand()).map(RandomLinkedNode::getNext).orElse(null));
            cur = next;
        }
        // 拆分
        RandomLinkedNode result = head.getNext();
        cur = head;
        while (null != cur) {
            next = cur.getNext().getNext();
            curCopy = cur.getNext();
            cur.setNext(next);
            curCopy.setNext(Optional.ofNullable(next).map(RandomLinkedNode::getNext).orElse(null));
            cur = next;
        }
        return result;
    }
}
