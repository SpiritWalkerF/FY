package offer.ndty;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.*;
import java.util.stream.Stream;

//请完善以下程序，输入为字符数组（数组内每个字符均不相同）和个数n，返回值是由这些字符组成的所有长度为n的字符串
// 例如输入为{'a','b','c'}和个数1，则返回值为{"a","b","c"}
//例如输入为{'a','b','c','d'}和个数2，则返回值为{"ab","ac","ad","ba","bc","bd","ca","cb","cd","da","db","dc"}
public class Q2 {

    List<String> strings = new ArrayList<>();

    @Test
    public void testMain() {
        char[] chars = {'a', 'b', 'c', 'd'};
        int n = 2;
        doit(chars, n);
    }
    public String[] doit(char[] chars, int n) {
        List<Character> list = new ArrayList<>();
        backTracking(list, chars, n);
        return strings.toArray(new String[0]);
    }
    private void backTracking(List<Character> list, char[] chars, int n) {
        if(list.size() == n) {
            StringBuilder stringBuilder =new StringBuilder();
            for(Character e : list) {
                stringBuilder.append(e);
            }
            strings.add(stringBuilder.toString());
            return;
        }
        for(int i=0; i<chars.length; i++) {
            if(list.contains(chars[i])) {
                continue;
            }
            list.add(chars[i]);
            backTracking(list, chars, n);
            list.remove((Character) chars[i]);
        }
    }
}
