package test.wash;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class Wash {
    @Test
    public void testMain() throws InterruptedException {
        Room room = new Room(3);
        PersonWash femaleWash = new PersonWash(room, "F");
        PersonWash maleWash = new PersonWash(room, "M");

        Thread thread1 = new Thread(femaleWash);
        Thread thread2 = new Thread(femaleWash);
        Thread thread3 = new Thread(femaleWash);
        Thread thread4 = new Thread(femaleWash);
        Thread thread5 = new Thread(femaleWash);
        Thread thread6 = new Thread(maleWash);
        Thread thread7 = new Thread(maleWash);
        Thread thread8 = new Thread(maleWash);
        Thread thread9 = new Thread(maleWash);
        Thread thread10 = new Thread(maleWash);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();
        thread10.join();
    }
}
