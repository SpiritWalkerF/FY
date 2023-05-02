package test.q1115;

public class BarThread implements Runnable {
    private TwoThreadsFooBar twoThreadsFooBar;

    BarThread(TwoThreadsFooBar twoThreadsFooBar) {
        this.twoThreadsFooBar = twoThreadsFooBar;
    }

    @Override
    public void run() {
        try {
            twoThreadsFooBar.foo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
