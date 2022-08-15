package cn.sh.lz.cig.c1p5;

import java.util.Stack;

/**
 * Created by Link at 10:35 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        System.out.println(stack);

        SortByStack sortByStack = new SortByStack();
        sortByStack.asc(stack);
        System.out.println(stack);

        sortByStack.desc(stack);
        System.out.println(stack);
    }
}
