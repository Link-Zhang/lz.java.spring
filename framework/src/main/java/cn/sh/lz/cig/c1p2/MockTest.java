package cn.sh.lz.cig.c1p2;

/**
 * Created by Link at 16:18 on 2022/08/03.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.offer(1);
        System.out.println(queue.peek());
        queue.offer(2);
        System.out.println(queue.peek());
        queue.offer(3);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
    }
}
