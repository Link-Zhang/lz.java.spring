package cn.sh.lz.cig.c1p4;

/**
 * Created by Link at 09:40 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        CatDogQueue queue = new CatDogQueue();
        queue.offer(new Cat());
        queue.offer(new Dog());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isDogEmpty());

        System.out.println();

        queue.pollCat();
        System.out.println(queue.isEmpty());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isDogEmpty());

        System.out.println();

        queue.pollPet();
        System.out.println(queue.isEmpty());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isDogEmpty());
    }
}
