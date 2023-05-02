package test.q1115;

public class TwoThreadsFooBar {
    private int n;
    private Object obj = new Object();
    private volatile boolean isFoo = true;

    public TwoThreadsFooBar(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                if (!isFoo) {
                    obj.wait();
                }
                System.out.println("foo");
                isFoo = false;
                obj.notifyAll();
            }
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                if (isFoo) {
                    obj.wait();
                }
                System.out.println("bar");
                isFoo = true;
                obj.notifyAll();
            }
        }
    }

}
