package test.wash;

import java.util.Random;

public class PersonWash implements Runnable {
    private Room room;
    private String gender;
    private boolean washed = false;
    PersonWash(Room room, String gender) {
        this.room = room;
        this.gender = gender;
    }

    @Override
    public void run() {
        while (!washed) {
            if (room.person.size() < room.limit && room.checkGender(gender)) {
                washed =room.tryWash(gender);
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Random random =new Random();

        try {
            room.wash((random.nextInt(10) + 1) * 1000, gender);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
