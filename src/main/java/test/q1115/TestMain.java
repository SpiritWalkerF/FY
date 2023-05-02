package test.q1115;

public class TestMain {

    public static void main(String[] args) {
        int n =3;
        TwoThreadsFooBar fooBar = new TwoThreadsFooBar(n);
        FooThread foo = new FooThread(fooBar);
        BarThread bar = new BarThread(fooBar);
        Thread thread1 = new Thread(foo);
        Thread thread2 = new Thread(bar);
        thread1.start();
        thread2.start();
    }
}
