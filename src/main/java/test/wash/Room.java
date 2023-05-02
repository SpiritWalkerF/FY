package test.wash;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    int limit;
    volatile List<String> person;
    Room(int limit) {
        this.limit = limit;
        this.person = new ArrayList<>();
    }
    synchronized public boolean  tryWash(String gender) {
            if (this.person.size() < limit && checkGender(gender)) {
                this.person.add(gender);
                System.out.println(Thread.currentThread().getName()+" start wash " + gender + " data:" + LocalDateTime.now());
                return true;
            } else {
                return false;
            }
    }
    public void wash(int time, String gender) throws InterruptedException {
        Thread.sleep(time);
        person.remove(gender);
        System.out.println(Thread.currentThread().getName()+" time:" + time + " gender:" + gender+ " data:" + LocalDateTime.now() + " Room:" + person);
    }
    public boolean checkGender(String gender) {
        switch (gender) {
            case "F":
                return !person.contains("M");
            case "M":
                return !person.contains("F");
            default:
                break;
        }
        return false;
    }
}