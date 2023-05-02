package offer.ndty;

import org.junit.jupiter.api.Test;

public class Q1 {


    @Test
    public void testMain() {
        int input = 89;
        scoreLevel(input);
    }

    public void scoreLevel(int score) {
        if(score<=100 && score>=90) {
            System.out.println("A");
        }else if(score<=89 && score>=80) {
            System.out.println("B");
        }else if(score<=79 && score>=70) {
            System.out.println("C");
        }else if(score<=69 && score>=60) {
            System.out.println("D");
        }else if(score<=59 && score>=0) {
            System.out.println("E");
        }else {
            System.out.println("Score Error.");
        }
    }


}
