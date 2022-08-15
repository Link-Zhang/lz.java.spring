package cn.sh.lz.cig.c1p10;

import java.util.LinkedList;

/**
 * Created by Link at 11:37 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class SubArray {
    public int getNumberGreaterThanMaxMinusMin(int[] array, int num) {
        if (null == array) {
            return 0;
        }
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < array.length) {
            while (j < array.length) {
                while (!qMin.isEmpty() && array[qMin.peekLast()] >= array[j]) {
                    qMin.pollLast();
                }
                qMin.addLast(j);
                while (!qMax.isEmpty() && array[qMax.peekLast()] <= array[j]) {
                    qMax.pollLast();
                }
                qMax.addLast(j);
                if (array[qMax.getFirst()] - array[qMin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qMin.peekFirst() == i) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == i)
                qMax.pollFirst();
            result += j - i;
            i++;
        }
        return result;
    }
}
