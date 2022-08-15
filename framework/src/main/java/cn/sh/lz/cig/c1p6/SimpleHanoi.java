package cn.sh.lz.cig.c1p6;

import java.util.Stack;

/**
 * Created by Link at 11:10 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class SimpleHanoi {
    // O(2^n)
    // 2^n-1
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
        int count = 0;
        while (rS.size() != number + 1) {
            if (1 == number % 2) {
                // L=>R
                count += legalMove(left, right, lS, rS);
                // L=>M
                int flag = legalMove(left, middle, lS, mS);
                count += flag;
                if (0 == flag) {
                    break;
                }
            } else {
                // L=>M
                count += legalMove(left, middle, lS, mS);
                // L=>R
                count += legalMove(left, right, lS, rS);
            }
            // M=>R
            count += legalMove(middle, right, mS, rS);
        }
        return count;
    }

    public int legalMove(String AName, String BName, Stack<Integer> A, Stack<Integer> B) {
        if (A.peek() < B.peek()) {
            // A=>B
            move(A.peek(), AName, BName);
            B.push(A.pop());
            return 1;
        } else if (A.peek() > B.peek()) {
            // B=>A
            move(B.peek(), BName, AName);
            A.push(B.pop());
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
