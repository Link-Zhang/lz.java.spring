package cn.sh.lz.cig.c1p3;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Link at 16:53 on 2022/08/03.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class ReverseStack {
    public void doReverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int nadir = getAndRemoveNadir(stack);
        doReverse(stack);
        stack.push(nadir);
    }

    public int getAndRemoveNadir(Stack<Integer> stack) {
        int president = stack.pop();
        if (stack.isEmpty()) {
            return president;
        } else {
            int vicePresident = getAndRemoveNadir(stack);
            stack.push(president);
            return vicePresident;
        }
    }

    public int nadir(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int president = stack.pop();
        if (stack.isEmpty()) {
            stack.push(president);
            return president;
        } else {
            int vicePresident = nadir(stack);
            stack.push(president);
            return vicePresident;
        }
    }
}
