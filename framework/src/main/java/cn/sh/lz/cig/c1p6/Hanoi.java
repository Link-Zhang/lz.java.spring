package cn.sh.lz.cig.c1p6;

import java.util.Stack;

/**
 * Created by Link at 10:51 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class Hanoi {
    public enum Action {
        No, LToM, MToL, MToR, RToM
    }

    // O(3^n)
    // 3^n-1
    public int hanoi(int number, String left, String middle, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = number; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int count = 0;
        while (rS.size() != number + 1) {
            count += fromStackToStack(record, Action.MToL, Action.LToM, lS, mS, left, middle);
            count += fromStackToStack(record, Action.LToM, Action.MToL, mS, lS, middle, left);
            count += fromStackToStack(record, Action.MToR, Action.RToM, rS, mS, right, middle);
            count += fromStackToStack(record, Action.RToM, Action.MToR, mS, rS, middle, right);
        }
        return count;
    }

    public int fromStackToStack(Action[] record, Action banAction, Action action, Stack<Integer> fromStack, Stack<Integer> toStack, String from, String to) {
        if (record[0] != banAction && fromStack.peek() < toStack.peek()) {
            toStack.push(fromStack.pop());
            move(toStack.peek(), from, to);
            record[0] = action;
            return 1;
        }
        return 0;
    }

    private void move(int number, String from, String to) {
        if (0 > from.compareTo(to)) {
            System.out.println("Move " + number + " : " + from + " => " + to + ".");
        } else {
            System.out.println("Move " + number + " : " + to + " <= " + from + ".");
        }
    }
}
