package cn.sh.lz.cig.c5p1;

import cn.sh.lz.cig.c5c.StringUtils;

/**
 * Created by Link at 17:07 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "231";
        String str3 = "321";
        String str4 = "233";
        StringUtils stringUtils = new StringUtils();
        System.out.println(stringUtils.isDeformation(str1, str2));
        System.out.println(stringUtils.isDeformation(str3, str4));
        System.out.println(stringUtils.isDeformation(str3, str1));
    }
}
