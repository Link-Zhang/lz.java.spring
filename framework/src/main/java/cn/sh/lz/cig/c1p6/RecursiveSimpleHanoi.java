package cn.sh.lz.cig.c1p6;

/**
 * Created by Link at 10:51 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class RecursiveSimpleHanoi {
    // O(2^n)
    // 2^n-1
    public int hanoi(int number, String left, String middle, String right) {
        if (number < 1)
            return 0;
        return process(number, left, middle, right);
    }

    private int process(int number, String left, String middle, String right) {
        if (1 == number) {
            move(number, left, right);
            return 1;
        }
        int part1 = process(number - 1, left, right, middle);
        int part2 = 1;
        move(number, left, right);
        int part3 = process(number - 1, middle, left, right);
        return part1 + part2 + part3;
    }

    private void move(int number, String from, String to) {
        if (0 > from.compareTo(to)) {
            System.out.println("Move " + number + " : " + from + " => " + to + ".");
        } else {
            System.out.println("Move " + number + " : " + to + " <= " + from + ".");
        }
    }
}
