package test.q1115;

public class FooThread implements Runnable {
    private TwoThreadsFooBar twoThreadsFooBar;

    FooThread(TwoThreadsFooBar twoThreadsFooBar) {
        this.twoThreadsFooBar = twoThreadsFooBar;
    }

    @Override
    public void run() {
        try {
            twoThreadsFooBar.bar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
