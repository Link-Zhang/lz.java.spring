package cn.sh.lz.cig.c1p7;

import java.util.LinkedList;

/**
 * Created by Link at 14:49 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class SlidingWindow {
    public int[] getMax(int[] arr, int w) {
        if (null == arr || w < 1 || arr.length < w) {
            return null;
        }
        // 双端队列:队尾插入、删除；队头删除；存数组的下标
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 入栈
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                // 队尾小，删除
                qMax.pollLast();
            }
            qMax.addLast(i);

            // 出栈
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }

            // 出结果
            if (i >= w - 1) {
                result[index++] = arr[qMax.peekFirst()];
            }
        }
        return result;
    }

    public int[] getMin(int[] arr, int w) {
        if (null == arr || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qMin = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[i]) {
                qMin.pollLast();
            }
            qMin.addLast(i);
            if (qMin.peekFirst() == i - w) {
                qMin.pollFirst();
            }
            if (i >= w - 1) {
                result[index++] = arr[qMin.peekFirst()];
            }
        }
        return result;
    }

    public int[] getSum(int[] arr, int w) {
        if (null == arr || w < 1 || arr.length < w) {
            return null;
        }
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < w) {
                result[index] += arr[i];
                continue;
            }
            result[index + 1] = result[index] - arr[i - w] + arr[i];
            index++;
        }
        return result;
    }
}
