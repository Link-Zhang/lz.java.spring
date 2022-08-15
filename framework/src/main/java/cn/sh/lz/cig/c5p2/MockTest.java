package cn.sh.lz.cig.c5p2;

import cn.sh.lz.cig.c5c.StringUtils;

/**
 * Created by Link at 17:22 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        String str = "A-1B--2C--D6E";
        StringUtils stringUtils = new StringUtils();
        System.out.println(stringUtils.getNumberSum(str));
    }
}
