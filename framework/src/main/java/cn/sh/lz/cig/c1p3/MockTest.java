package cn.sh.lz.cig.c1p3;

import java.util.Stack;

/**
 * Created by Link at 16:52 on 2022/08/03.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        ReverseStack reverseStack = new ReverseStack();
        int nadir = reverseStack.nadir(stack);
        System.out.println(nadir);
        System.out.println(stack);
        reverseStack.doReverse(stack);
        System.out.println(stack);
        reverseStack.getAndRemoveNadir(stack);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
