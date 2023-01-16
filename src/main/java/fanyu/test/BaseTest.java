package fanyu.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BaseTest {

    @Test
    public void testDeque() {
        Deque<Character> deque = new LinkedList<>();
        deque.add('a');
        deque.add('b');
        System.out.println(deque.stream().count());

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        StringBuilder stringBuilder = new StringBuilder();
//        stringList.forEach(stringBuilder.append());
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void testCalculate(){
        int n1 =58;
        System.out.println(n1%10);
        System.out.println(n1/10);

        int n2 = 7;
        System.out.println(n2/10);

    }
}
