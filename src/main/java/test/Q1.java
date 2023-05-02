package test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
//        匹配模式 = "xyyx", 字符串 = "研发,产品,产品,研发" 返回 ture
//        匹配模式 = "xxyy", 字符串 = "研发,产品,产品,研发" 返回 false
//        匹配模式 = "yxxy", 字符串 = "研发,产品,产品,研发" 返回 ture
public class Q1 {
    @Test
    public void testMain() {
        System.out.println(matchOrNot("xyyx","研发,产品,产品,研发"));
        System.out.println(matchOrNot("xxyy", "研发,产品,产品,研发"));
        System.out.println(matchOrNot("yxxy", "研发,产品,产品,研发"));
    }
    public boolean matchOrNot(String input1, String content) {

        char[] pattern = input1.toCharArray();
        String[] strArray = content.split(",");
        if (pattern.length != strArray.length) {
            return false;
        }
        Map<String, Character> patternMap = new HashMap<>();
        for (int i = 0; i < strArray.length; i++) {
            if (!patternMap.containsKey(strArray[i])) {
                patternMap.put(strArray[i], pattern[i]);
                continue;
            }
            if (!patternMap.get(strArray[i]).equals(pattern[i])) {
                return false;
            }
        }
        return true;
    }
}
