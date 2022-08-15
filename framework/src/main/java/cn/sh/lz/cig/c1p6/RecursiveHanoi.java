package cn.sh.lz.cig.c1p6;

/**
 * Created by Link at 10:51 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class RecursiveHanoi {
    // O(3^n)
    // 3^n-1
    public int hanoi(int number, String left, String middle, String right) {
        if (number < 1)
            return 0;
        return process(number, left, middle, right, left, right);
    }

    private int process(int number, String left, String middle, String right, String from, String to) {
        if (1 == number) {
            if (middle.equals(from) || middle.equals(to)) {
                move(number, from, to);
                return 1;
            } else {
                move(number, from, middle);
                move(number, middle, to);
                return 2;
            }
        }
        if (middle.equals(from) || middle.equals(to)) {
            String help = (left.equals(from) || left.equals(to)) ? right : left;
            int part1 = process(number - 1, left, middle, right, from, help);
            int part2 = 1;
            move(number, from, to);
            int part3 = process(number - 1, left, middle, right, help, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(number - 1, left, middle, right, from, to);
            int part2 = 1;
            move(number, from, middle);
            int part3 = process(number - 1, left, middle, right, to, from);
            int part4 = 1;
            move(number, middle, to);
            int part5 = process(number - 1, left, middle, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    private void move(int number, String from, String to) {
        if (0 > from.compareTo(to)) {
            System.out.println("Move " + number + " : " + from + " => " + to + ".");
        } else {
            System.out.println("Move " + number + " : " + to + " <= " + from + ".");
        }
    }
}
