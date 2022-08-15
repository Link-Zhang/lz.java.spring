package cn.sh.lz.cig.c1p6;

/**
 * Created by Link at 10:51 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        RecursiveSimpleHanoi recursiveSimpleHanoi = new RecursiveSimpleHanoi();
        int count = recursiveSimpleHanoi.hanoi(2, "left", "middle", "right");
        System.out.println(count);

        SimpleHanoi simpleHanoi = new SimpleHanoi();
        count = simpleHanoi.hanoi(4, "left", "middle", "right");
        System.out.println(count);

        RecursiveHanoi recursiveHanoi = new RecursiveHanoi();
        count = recursiveHanoi.hanoi(4, "left", "middle", "right");
        System.out.println(count);

        Hanoi hanoi = new Hanoi();
        count = hanoi.hanoi(2, "left", "middle", "right");
        System.out.println(count);
    }
}
