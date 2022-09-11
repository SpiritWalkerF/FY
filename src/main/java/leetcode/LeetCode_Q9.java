package leetcode;

import org.junit.jupiter.api.Test;

/**
 * 判断回文
 */
public class LeetCode_Q9 {
    int x = 121;

    @Test
    public void testMain(){
        System.out.println(isPalindrome(x));

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int begin =0;
        int end =chars.length-1;

        while (end>=begin) {
            if(chars[begin] != chars[end]) {
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }
}
