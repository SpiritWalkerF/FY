package test;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class test {

    @Test
    public void testMain() {
        Random random =new Random();
        for(int i=0;i<10;i++) {
            System.out.println((random.nextInt(10) + 1) * 1000);
        }

    }
}
