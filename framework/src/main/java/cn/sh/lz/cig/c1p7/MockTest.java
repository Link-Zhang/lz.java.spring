package cn.sh.lz.cig.c1p7;

import java.util.Arrays;

/**
 * Created by Link at 14:48 on 2022/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 4, 2, 3, 6, 7};
        int w = 3;
        SlidingWindow slidingWindow = new SlidingWindow();
        int[] max = slidingWindow.getMax(arr, w);
        System.out.println(Arrays.toString(max));

        int[] min = slidingWindow.getMin(arr, w);
        System.out.println(Arrays.toString(min));

        int[] sum = slidingWindow.getSum(arr, w);
        System.out.println(Arrays.toString(sum));
    }
}
