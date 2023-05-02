package leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode_Q121 {

    @Test
    public void testMain(){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }

    public int maxProfit(int[] prices) {
        int minimum = Integer.MAX_VALUE;
        int maxVal = 0;
        int tempMax =0;
        for(int cur : prices) {
            if(cur > maxVal) {
                maxVal = cur;
            }
            if(cur < minimum) {
                minimum = cur;
                maxVal = cur;
            }
            tempMax = Math.max(tempMax, maxVal-minimum);
        }

        return tempMax;
    }
}
