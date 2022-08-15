package cn.sh.lz.cig.c1p10;

/**
 * Created by Link at 11:35 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 6, 8};
        int number = 2;
        SubArray subArray = new SubArray();
        System.out.println(subArray.getNumberGreaterThanMaxMinusMin(array, number));
    }
}
