package offer.ndty;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//手动实现两个超长数字相乘
//例如输入：12345678900
//        98765432100
//输出结果：1219326311126352690000
public class Q3 {

    String num1 = "12345678900";
    String num2 = "98765432100";

    @Test
    public void testMain() {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] int1 = transInt(char1);
        int[] int2 = transInt(char2);

        List<Integer[]> resList = new ArrayList<>();
        for (int i = 0; i < int2.length; i++) {
            if (int2[i] == 0) {
                continue;
            }
            Integer[] temp = new Integer[int1.length + i + 1];
            Arrays.fill(temp, -1);
            int pre = 0;
            for (int m = 0; m < i; m++) {
                temp[m] = 0;
            }
            for (int j = 0; j < int1.length; j++) {
                int one = int2[i] * int1[j] + pre;
                temp[j+i] = one % 10;
                pre = one / 10;
            }
            if (pre != 0) {
                temp[temp.length - 1] = pre;
            }
            resList.add(temp);
        }
        int pre2 = 0;
        int[] res = new int[int1.length + int2.length];
        for (int j = 0; j < resList.size(); j++) {
            Integer[] temp = resList.get(j);
            for (int i = j; i < temp.length; i++) {
                if (temp[i] == -1) {
                    break;
                }
                int e = res[i] + temp[i] + pre2;
                res[i] = e % 10;
                pre2 = e / 10;
            }
            int k = temp.length;
            while (pre2 != 0) {
                int e;
                e = res[k] + pre2;
                res[k] = e % 10;
                pre2 = e / 10;
                k++;
            }
            System.out.println(Arrays.asList(res));
        }

        System.out.println(Arrays.asList(res));
    }
    private int[] transInt(char[] chars) {
        int[] intArray = new int[chars.length];
        Arrays.fill(intArray, -1);
        for (int i = 0; i < chars.length; i++) {
            intArray[chars.length - 1 - i] = chars[i] - '0';
        }
        return intArray;
    }

}
