package cn.sh.lz.cig.c5c;

/**
 * Created by Link at 17:08 on 2022/08/08.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class StringUtils {
    public boolean isDeformation(String str1, String str2) {
        if (null == str1 || null == str2 || str1.length() != str2.length()) {
            return false;
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chas1.length; i++) {
            map[chas1[i]]++;
        }
        for (int i = 0; i < chas2.length; i++) {
            if (map[chas2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public int getNumberSum(String str) {
        if (null == str) {
            return 0;
        }
        char[] charArray = str.toCharArray();
        int result = 0;
        int number = 0;
        boolean positive = true;
        int cur = 0;
        for (int i = 0; i < str.length(); i++) {
            cur = charArray[i] - '0';
            if (cur < 0 || cur > 9) {
                result += number;
                number = 0;
                if ('-' == charArray[i]) {
                    if (i - 1 > -1 && '-' == charArray[i - 1]) {
                        positive = !positive;
                    } else {
                        positive = false;
                    }
                } else {
                    positive = true;
                }

            } else {
                number = number * 10 + (positive ? cur : -cur);
            }
        }
        result += number;
        return result;
    }
}
